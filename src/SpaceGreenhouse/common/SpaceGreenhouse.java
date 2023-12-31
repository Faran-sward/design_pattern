package SpaceGreenhouse.common;

import SpaceGreenhouse.Home;
import SpaceGreenhouse.common.exception.MyException;
import SpaceGreenhouse.common.exception.product.conc.CropsNotFoundException;
import SpaceGreenhouse.common.exception.product.conc.SeedNotFoundException;
import SpaceGreenhouse.common.SpaceGreenhouse.ISpaceGreenhouse;
import SpaceGreenhouse.common.product.AbstractCrops;
import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.common.status.SpaceGreenhouseBlockStatus;
import SpaceGreenhouse.common.status.product.Shape;
import SpaceGreenhouse.common.utils.JsonOp;
import SpaceGreenhouse.pattern.factory.conc.CropsFactory;
import SpaceGreenhouse.pattern.iterator.conc.SpaceGreenhouseIterator;

import java.util.*;

/**
 * 赛尔个人农场
 * implements ISpaceGreenhouse
 */
public class SpaceGreenhouse implements ISpaceGreenhouse {

    /**
     * 太空温室块数量
     */
    private Integer SpaceGreenhouseBlockCount = 9;
    /**
     * 形状
     */
    private Shape shape = Shape.CIRCULAR;
    /**
     * 面积
     */
    private Integer area = 1;
    /**
     * 太空温室块列表
     */
    private List<SpaceGreenhouseBlock> SpaceGreenhouseBlockList;

    public static SpaceGreenhouse getInstance(){
        return new SpaceGreenhouse();
    }

    private SpaceGreenhouse(){
        SpaceGreenhouseBlockList = new ArrayList<>();
        for (int i = 0; i < SpaceGreenhouseBlockCount; ++i) {
            SpaceGreenhouseBlockList.add(new SpaceGreenhouseBlock());
        }
    }
    /**
     * 迭代器
     *
     * @return
     */
    public SpaceGreenhouseIterator getIterator() {
        return (new SpaceGreenhouseIterator(SpaceGreenhouseBlockList));
    }

    /**
     * 种下种子
     * 批量操作
     *
     * @param seed
     * @throws MyException
     */
    @Override
    public void plantBatchSeeds(AbstractSeed seed) {
        //寻找空地，一键播种
        for (SpaceGreenhouseBlock item : SpaceGreenhouseBlockList) {
            if (item.getSeed() != null) {
                SpaceGreenhouseGrowth.plantSeed(seed, item);
            }
        }
        //这里是不是要改成播种成功，因为不是所有的都会播种
        System.out.println("所有空地均已播种成功");
//        if (seedList.size() > SpaceGreenhouseBlockList.size())
//            throw new MyException("作物数量太多，无法种植");
    }

    /**
     * 种下种子(重载)
     * 批量操作
     *
     * @param name
     * @throws SeedNotFoundException
     */
    public void plantBatchSeeds(String name) throws SeedNotFoundException {
        //寻找空地，一键播种
        for (SpaceGreenhouseBlock item : SpaceGreenhouseBlockList) {
            if (item.getSeed() == null) {
                if (!SpaceGreenhouseGrowth.plantSeed(name, item)) break;
            }
        }
        System.out.println("批量播种结束");
//        if (seedList.size() > SpaceGreenhouseBlockList.size())
//            throw new MyException("作物数量太多，无法种植");
    }
    /**
     * 收获作物
     * 批量操作
     * @return
     */
    @Override
    public Map<AbstractCrops,Integer> harvestBatchSeeds() {
        Map<AbstractCrops, Integer> map = new LinkedHashMap<>();
        /**
         * 存入map里面
         */
        for (SpaceGreenhouseBlock item : SpaceGreenhouseBlockList) {
            if (item.getSeed()!=null&&item.getSeedStatus() != null && item.getSeedStatus() >= 6) {
                String name = item.getSeed().getName().replace("种子","");
                item.setSeed(null);
                CropsFactory cropsFactory = CropsFactory.newInstance();
                try {
                    AbstractCrops crops = cropsFactory.create(Home.cropsMap.get(name));
                    int num=map.get(crops)==null?0:map.get(crops);
                    int cropsNum;
                    Set<SpaceGreenhouseBlockStatus> blockStatusSet = item.getBlockStatusSet();
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
                    map.put(crops,num+cropsNum);
                } catch (CropsNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        if (map.size()==0) {
            System.out.println("抱歉，暂无成熟作物可收获");
            return null;
        }
        /**
         * 输出太空温室收获的东西
         */
        for(var item:map.entrySet()){
            AbstractCrops key = item.getKey();
            Integer value = item.getValue();
            System.out.println("共收获" + key.getName() + "数量：" + value);
        }
        return map;
    }

    /**
     * 展示农场
     */
    public void showSpaceGreenhouse(String weather) {
        System.out.println("\n太空温室状态如下：");
        for (int i = 0; i < SpaceGreenhouseBlockList.size(); i += 3) {
            System.out.print(SpaceGreenhouseBlockList.get(i).getSeed() == null ? "┏━┓" : "┎┰┒");
            System.out.print(SpaceGreenhouseBlockList.get(i + 1).getSeed() == null ? "┏━┓" : "┎┰┒");
            System.out.print(SpaceGreenhouseBlockList.get(i + 2).getSeed() == null ? "┏━┓" : "┎┰┒");
            System.out.println(" ");
            System.out.print(SpaceGreenhouseBlockList.get(i).getSeed() == null ? "┗━┛" : "┖┸┚");
            System.out.print(SpaceGreenhouseBlockList.get(i + 1).getSeed() == null ? "┗━┛" : "┖┸┚");
            System.out.print(SpaceGreenhouseBlockList.get(i + 2).getSeed() == null ? "┗━┛" : "┖┸┚");
            System.out.println(i == 0 ? "①~③" : i == 3 ? "④~⑥" : "⑦~⑨");
        }
        //随即添加太空温室块状态
        for(SpaceGreenhouseBlock block:SpaceGreenhouseBlockList){
            block.addStatus(weather);
        }
    }
}
