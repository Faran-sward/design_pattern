package SpaceGreenhouse.common;

import SpaceGreenhouse.common.Greenhouse.ISpaceGreenhouseBlock;
import SpaceGreenhouse.common.product.AbstractCrops;
import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.common.status.SpaceGreenhouseBlockStatus;
import SpaceGreenhouse.common.status.SeedStatus;
import SpaceGreenhouse.common.status.product.Shape;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class SpaceGreenhouseBlock implements ISpaceGreenhouseBlock {
    /**
     * 形状
     */
    private final Shape shape = Shape.CIRCULAR;
    /**
     * 面积
     */
    private final Double area = 1.0;
    /**
     * 种子
     */
    private AbstractSeed seed;
    /**
     * 种子状态
     * 这里调用 SeedStatus.getSeedStatusByNum(int number)
     * 获取太空温室状态
     */
    private Integer seedStatus;
    /**
     * 太空温室块状态列表
     */
    private Set<SpaceGreenhouseBlockStatus> blockStatusSet = new LinkedHashSet<>();


    public Shape getShape() {
        return shape;
    }

    public Double getArea() {
        return area;
    }

    public AbstractSeed getSeed() {
        return seed;
    }

    public void setSeed(AbstractSeed seed) {
        this.seed = seed;
    }

    public Integer getSeedStatus() {
        return seedStatus;
    }

    public void setSeedStatus(Integer seedStatus) {
        this.seedStatus = seedStatus;
    }

    public Set<SpaceGreenhouseBlockStatus> getBlockStatusSet() {
        return blockStatusSet;
    }

    public void setBlockStatusSet(Set<SpaceGreenhouseBlockStatus> blockStatusSet) {
        this.blockStatusSet = blockStatusSet;
    }


    @Override
    public void plantSeed(AbstractSeed seed) {
        SpaceGreenhouseGrowth.plantSeed(seed,this);
    }

    @Override
    public AbstractCrops harvestCrops() {
        return SpaceGreenhouseGrowth.harvestCrops(this);
    }

    /**
     * 作物生长方法
     * 采用随机方法
     */
    public void growth() {
        //随机增加生长周期(0~2)
        Double growth = Math.floor(Math.random() * 3);
        Integer seedStatus = getSeedStatus() + growth.intValue();
        setSeedStatus(seedStatus > 7 ? 7 : seedStatus);
    }

    /**
     * 增加太空温室状态
     * 随机
     */
    public void addStatus(String weather) {
        //0~2随机增加状态，3不增加异常状态
        Double random = Math.floor(Math.random() * 5);
        int i = random.intValue();
        if(i>=3) return;
        if(i==2&& Objects.equals(weather, "雨天"))return;
        SpaceGreenhouseBlockStatus value = SpaceGreenhouseBlockStatus.values()[i];
        blockStatusSet.add(value);
    }

    /**
     * 获取太空温室块信息
     */
    public void getInfo() {
        String seedInfo = seed == null ? "抱歉，该太空温室块上暂未种植作物" : ("作物：" + seed.getName());
        StringBuilder statusInfo = new StringBuilder("状态：");
        StringBuilder growthInfo = new StringBuilder("生长周期：");
        if (blockStatusSet == null || blockStatusSet.size() == 0) {
            statusInfo.append("正常");
        } else {
            for (SpaceGreenhouseBlockStatus i : blockStatusSet) {
                statusInfo.append(i.getText()).append("  ");
            }
        }
        if (seed != null && seedStatus != null) {
            growthInfo.append(SeedStatus.getSeedStatusByNum(seedStatus).getText()).append("期");
        }
        System.out.println(seedInfo);
        System.out.println(statusInfo);
        System.out.println(growthInfo);
    }
}
