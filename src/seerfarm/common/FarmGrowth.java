package seerfarm.common;

import seerfarm.common.exception.product.conc.CropsNotFoundException;
import seerfarm.common.exception.product.conc.FertilizerNotFoundException;
import seerfarm.common.exception.product.conc.SeedNotFoundException;
import seerfarm.common.product.AbstractCrops;
import seerfarm.common.product.AbstractFertilizer;
import seerfarm.common.product.AbstractSeed;
import seerfarm.common.status.FarmBlockStatus;
import seerfarm.common.status.SeedStatus;
import seerfarm.common.utils.JsonOp;
import seerfarm.pattern.adapter.conc.seerAdapter;
import seerfarm.pattern.adapter.conc.WeatherAdapter;
import seerfarm.pattern.factory.conc.CropsFactory;
import seerfarm.pattern.factory.conc.FertilizerFactory;
import seerfarm.pattern.factory.conc.SeedFactory;
import seerfarm.Home;
import seerfarm.pattern.state.Context;

import java.util.*;

/**
 * 种植方法是一个静态类()有很多静态方法
 */
public class FarmGrowth {
    //赛尔
    private static final seerAdapter SEER = seerAdapter.getInstance();
    //
    private static final SeedFactory seedFactory = Home.seedFactory;

    private static final FertilizerFactory fertilizerFactory = Home.fertilizerFactory;

    private static final CropsFactory cropsFactory = Home.cropsFactory;

    private static final seerfarmWarehouse seerfarmWarehouse = SEER.getFarmWarehouse();


    /**
     * 播种
     *
     * @param seed
     */
    public static boolean plantSeed(AbstractSeed seed, seerfarmBlock farmBlock) {
        if (seed == null) {
            System.out.println("您手上没有种子，无法种植");
            return false;
        } else {
            List<AbstractSeed> seeds = Collections.singletonList(seed);
            //仓库提供种子，调用职责链模式
            if (seerfarmWarehouse.provideItemToseer(seeds)) {
                System.out.println("正在播种" + seed.getName() + "...");
                farmBlock.setSeed(seed);
                //设置生长周期
                farmBlock.setSeedStatus(0);
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
    public static boolean plantSeed(String name, seerfarmBlock farmBlock) throws SeedNotFoundException {
        AbstractSeed seed = seedFactory.create(Home.seedMap.get(name));
        return plantSeed(seed, farmBlock);
    }

    /**
     * 铲除作物
     */
    public static void eradicateCrops(seerfarmBlock farmBlock) {
        if (farmBlock.getSeed() != null) {
            seerfarmWarehouse.getShovel().ToolBehavior();
            farmBlock.setSeed(null);
        } else {
            System.out.println("该土地上没有作物，不能铲除");
        }
    }

    /**
     * 松土
     */
    public static void loosenSoil() {
        seerfarmWarehouse.getHoe().ToolBehavior();
    }

    /**
     * 浇水
     */
    public static void watering(seerfarmBlock farmBlock) {
        Context context = new Context(WeatherAdapter.getInstance(), farmBlock);
        context.watering();
    }

    /**
     * 除虫
     */
    public static void disinsection(seerfarmBlock farmBlock) {
        Context context = new Context(WeatherAdapter.getInstance(), farmBlock);
        context.disInsection();
    }

    /**
     * 施肥
     *
     * @param fertilizer
     */
    public static void applyFertilizer(AbstractFertilizer fertilizer, seerfarmBlock farmBlock) {
        if (fertilizer == null) {
            System.out.println("请输入正确的肥料名称噢");
        } else if (farmBlock.getSeed() != null && farmBlock.getSeedStatus() != null && farmBlock.getSeedStatus() < 6) {
            Map<AbstractFertilizer, Integer> fertilizerMap = seerfarmWarehouse.getFertilizerMap();
            int oriNum = fertilizerMap.get(fertilizer);
            if (oriNum <= 0) {
                System.out.println("抱歉，该肥料暂无库存");
                return;
            }
            System.out.println("正在用" + fertilizer.getName() + "施肥...");
            Integer remainNum = seerfarmWarehouse.getFertilizerMap().get(fertilizer);
            remainNum -= 1;
            //设置新的数量
            seerfarmWarehouse.getFertilizerMap().put(fertilizer, remainNum);
            int status = farmBlock.getSeedStatus();
            Integer integer = fertilizer.fertilizerBehavior(status);
            //设置新的状态
            farmBlock.setSeedStatus(integer);
        }
    }

    /**
     * 施肥(重载)
     *
     * @param name
     */
    public static void applyFertilizer(String name, seerfarmBlock farmBlock) throws FertilizerNotFoundException {
        AbstractFertilizer fertilizer;
        fertilizer = fertilizerFactory.create(Home.fertilizerMap.get(name));
        applyFertilizer(fertilizer, farmBlock);
    }

    /**
     * 除草
     */
    public static void weed(seerfarmBlock farmBlock) {
        //若存在杂草状态，则将其删去
        farmBlock.getBlockStatusSet().removeIf(s -> s.equals(FarmBlockStatus.WEEDS));
        //调用镰刀除草
        seerfarmWarehouse.getSickle().ToolBehavior();
    }

    /**
     * 收获作物
     *
     * @return
     */
    public static AbstractCrops harvestCrops(seerfarmBlock farmBlock) {
        if (farmBlock.getSeed() == null) {
            System.out.println("该土地上没有作物，无法收获");
        } else if (farmBlock.getSeedStatus() < 6) {
            System.out.println("作物" + farmBlock.getSeed().getName() + "正处于" +
                    SeedStatus.getSeedStatusByNum(farmBlock.getSeedStatus()).getText() + "期，请过一段时间后再来收获"
            );
        } else {
            String name = farmBlock.getSeed().getName().replace("种子", "");
            farmBlock.setSeed(null);
            try {
                AbstractCrops crops = cropsFactory.create(Home.cropsMap.get(name));
                if (crops == null) {
                    return crops;
                }
                //根据农田不同的情况来设置产出的数量
                int cropsNum;
                Set<FarmBlockStatus> blockStatusSet = farmBlock.getBlockStatusSet();
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
                Map<AbstractCrops, Integer> cropsMap = seerfarmWarehouse.getCropsMap();
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
