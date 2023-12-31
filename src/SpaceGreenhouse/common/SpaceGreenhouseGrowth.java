package SpaceGreenhouse.common;

import SpaceGreenhouse.common.exception.product.conc.CropsNotFoundException;
import SpaceGreenhouse.common.exception.product.conc.FertilizerNotFoundException;
import SpaceGreenhouse.common.exception.product.conc.SeedNotFoundException;
import SpaceGreenhouse.common.product.AbstractCrops;
import SpaceGreenhouse.common.product.AbstractFertilizer;
import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.common.status.SpaceGreenhouseBlockStatus;
import SpaceGreenhouse.common.status.SeedStatus;
import SpaceGreenhouse.common.utils.JsonOp;
import SpaceGreenhouse.pattern.adapter.conc.SEERAdapter;
import SpaceGreenhouse.pattern.adapter.conc.WeatherAdapter;
import SpaceGreenhouse.pattern.factory.conc.CropsFactory;
import SpaceGreenhouse.pattern.factory.conc.FertilizerFactory;
import SpaceGreenhouse.pattern.factory.conc.SeedFactory;
import SpaceGreenhouse.Home;
import SpaceGreenhouse.pattern.state.Context;

import java.util.*;

/**
 * 种植方法是一个静态类()有很多静态方法
 */
public class SpaceGreenhouseGrowth {
    //赛尔
    private static final SEERAdapter SEER = SEERAdapter.getInstance();
    //
    private static final SeedFactory seedFactory = Home.seedFactory;

    private static final FertilizerFactory fertilizerFactory = Home.fertilizerFactory;

    private static final CropsFactory cropsFactory = Home.cropsFactory;

    private static final SpaceGreenhouseWarehouse SpaceGreenhouseWarehouse = SEER.getSpaceGreenhouseWarehouse();


    /**
     * 播种
     *
     * @param seed
     */
    public static boolean plantSeed(AbstractSeed seed, SpaceGreenhouseBlock SpaceGreenhouseBlock) {
        if (seed == null) {
            System.out.println("您手上没有种子，无法种植");
            return false;
        } else {
            List<AbstractSeed> seeds = Collections.singletonList(seed);
            //仓库提供种子，调用职责链模式
            if (SpaceGreenhouseWarehouse.provideItemToSEER(seeds)) {
                System.out.println("正在播种" + seed.getName() + "...");
                SpaceGreenhouseBlock.setSeed(seed);
                //设置生长周期
                SpaceGreenhouseBlock.setSeedStatus(0);
                return true;
            }
        }
        return false;
    }

    /**
     * 播种（重载）
     *
     * @param name
     */
    public static boolean plantSeed(String name, SpaceGreenhouseBlock SpaceGreenhouseBlock) throws SeedNotFoundException {
        AbstractSeed seed = seedFactory.create(Home.seedMap.get(name));
        return plantSeed(seed, SpaceGreenhouseBlock);
    }

    /**
     * 铲除作物
     */
    public static void eradicateCrops(SpaceGreenhouseBlock SpaceGreenhouseBlock) {
        if (SpaceGreenhouseBlock.getSeed() != null) {
            SpaceGreenhouseWarehouse.getShovel().ToolBehavior();
            SpaceGreenhouseBlock.setSeed(null);
        } else {
            System.out.println("该土地上没有作物，不能铲除");
        }
    }

    /**
     * 松土
     */
    public static void loosenSoil() {
        SpaceGreenhouseWarehouse.getHoe().ToolBehavior();
    }

    /**
     * 浇水
     */
    public static void watering(SpaceGreenhouseBlock SpaceGreenhouseBlock) {
        Context context = new Context(WeatherAdapter.getInstance(), SpaceGreenhouseBlock);
        context.watering();
    }

    /**
     * 除虫
     */
    public static void disinsection(SpaceGreenhouseBlock SpaceGreenhouseBlock) {
        Context context = new Context(WeatherAdapter.getInstance(), SpaceGreenhouseBlock);
        context.disInsection();
    }

    /**
     * 施肥
     *
     * @param fertilizer
     */
    public static void applyFertilizer(AbstractFertilizer fertilizer, SpaceGreenhouseBlock SpaceGreenhouseBlock) {
        if (fertilizer == null) {
            System.out.println("请输入正确的肥料名称噢");
        } else if (SpaceGreenhouseBlock.getSeed() != null && SpaceGreenhouseBlock.getSeedStatus() != null && SpaceGreenhouseBlock.getSeedStatus() < 6) {
            Map<AbstractFertilizer, Integer> fertilizerMap = SpaceGreenhouseWarehouse.getFertilizerMap();
            int oriNum = fertilizerMap.get(fertilizer);
            if (oriNum <= 0) {
                System.out.println("抱歉，该肥料暂无库存");
                return;
            }
            System.out.println("正在用" + fertilizer.getName() + "施肥...");
            Integer remainNum = SpaceGreenhouseWarehouse.getFertilizerMap().get(fertilizer);
            remainNum -= 1;
            //设置新的数量
            SpaceGreenhouseWarehouse.getFertilizerMap().put(fertilizer, remainNum);
            int status = SpaceGreenhouseBlock.getSeedStatus();
            Integer integer = fertilizer.fertilizerBehavior(status);
            //设置新的状态
            SpaceGreenhouseBlock.setSeedStatus(integer);
        }
    }

    /**
     * 施肥(重载)
     *
     * @param name
     */
    public static void applyFertilizer(String name, SpaceGreenhouseBlock SpaceGreenhouseBlock) throws FertilizerNotFoundException {
        AbstractFertilizer fertilizer;
        fertilizer = fertilizerFactory.create(Home.fertilizerMap.get(name));
        applyFertilizer(fertilizer, SpaceGreenhouseBlock);
    }

    /**
     * 除草
     */
    public static void weed(SpaceGreenhouseBlock SpaceGreenhouseBlock) {
        //若存在杂草状态，则将其删去
        SpaceGreenhouseBlock.getBlockStatusSet().removeIf(s -> s.equals(SpaceGreenhouseBlockStatus.WEEDS));
        //调用镰刀除草
        SpaceGreenhouseWarehouse.getSickle().ToolBehavior();
    }

    /**
     * 收获作物
     *
     * @return
     */
    public static AbstractCrops harvestCrops(SpaceGreenhouseBlock SpaceGreenhouseBlock) {
        if (SpaceGreenhouseBlock.getSeed() == null) {
            System.out.println("该土地上没有作物，无法收获");
        } else if (SpaceGreenhouseBlock.getSeedStatus() < 6) {
            System.out.println("作物" + SpaceGreenhouseBlock.getSeed().getName() + "正处于" +
                    SeedStatus.getSeedStatusByNum(SpaceGreenhouseBlock.getSeedStatus()).getText() + "期，请过一段时间后再来收获"
            );
        } else {
            String name = SpaceGreenhouseBlock.getSeed().getName().replace("种子", "");
            SpaceGreenhouseBlock.setSeed(null);
            try {
                AbstractCrops crops = cropsFactory.create(Home.cropsMap.get(name));
                if (crops == null) {
                    return crops;
                }
                //根据太空温室不同的情况来设置产出的数量
                int cropsNum;
                Set<SpaceGreenhouseBlockStatus> blockStatusSet = SpaceGreenhouseBlock.getBlockStatusSet();
                Random random = new Random();
                if (blockStatusSet.size() == 3) {
                    cropsNum = random.nextInt(2, 4);
                }
                else if (blockStatusSet.size() == 2) {
                    cropsNum = random.nextInt(5, 7);
                }
                else if(blockStatusSet.size()==1){
                    cropsNum=random.nextInt(8,9);
                }else{
                    cropsNum=10;
                }
                System.out.println("成功收获" + cropsNum + "株" + name + "，正在将其运往仓库...");
                Map<AbstractCrops, Integer> cropsMap = SpaceGreenhouseWarehouse.getCropsMap();
                int oriNum = cropsMap.get(crops);
                cropsMap.put(crops, oriNum + cropsNum);
                return crops;
            } catch (CropsNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
