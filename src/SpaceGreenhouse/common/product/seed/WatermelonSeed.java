package SpaceGreenhouse.common.product.seed;

import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.common.status.product.Color;
import SpaceGreenhouse.common.status.product.Size;

/**
 * 西瓜种子
 */
public class WatermelonSeed extends AbstractSeed implements Cloneable {
    /**
     * 名字
     */
    private final String name = "西瓜种子";
    /**
     * 颜色
     */
    private final Color color = Color.BLACK;
    /**
     * 大小
     */
    private final Size size = Size.BIG;
    /**
     * 生长周期
     */
    private final String growthCycle = "150天";
    /**
     * 价格
     */
    private final Double price = 10.0;

    public WatermelonSeed() {
    }


    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public Double getPrice() {
        return price;
    }
}
