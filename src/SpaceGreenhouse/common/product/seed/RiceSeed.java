package SpaceGreenhouse.common.product.seed;

import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.common.status.product.Color;
import SpaceGreenhouse.common.status.product.Size;

/**
 * 水稻种子
 */
public class RiceSeed extends AbstractSeed implements Cloneable {
    /**
     * 名字
     */
    private final String name = "水稻种子";
    /**
     * 颜色
     */
    private final Color color = Color.BROWN;
    /**
     * 大小
     */
    private final Size size = Size.SMALL;
    /**
     * 生长周期
     */
    private final String growthCycle = "80天";
    /**
     * 价格
     */
    private final Double price = 4.0;

    public RiceSeed() {
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
