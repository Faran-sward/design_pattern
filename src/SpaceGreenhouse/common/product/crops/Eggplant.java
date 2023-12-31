package SpaceGreenhouse.common.product.crops;

import SpaceGreenhouse.common.product.AbstractCrops;
import SpaceGreenhouse.common.status.product.Color;
import SpaceGreenhouse.common.status.product.Size;

/**
 * 茄子🍆
 */
public class Eggplant extends AbstractCrops implements Cloneable {
    /**
     * 名字
     */
    private final String name = "茄子\uD83C\uDF46";
    /**
     * 颜色
     */
    private final Color color = Color.PURPLE;
    /**
     * 大小
     */
    private final Size size = Size.MEDIUM;
    /**
     * 价格
     */
    private final Double price = 10.0;

    public Eggplant() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
