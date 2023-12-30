package seerfarm.common.product.crops;

import seerfarm.common.product.AbstractCrops;
import seerfarm.common.status.product.Color;
import seerfarm.common.status.product.Size;

/**
 * 西瓜🍉
 */
public class Watermelon extends AbstractCrops implements Cloneable {
    /**
     * 名字
     */
    private final String name = "西瓜\uD83C\uDF49";
    /**
     * 颜色
     */
    private final Color color = Color.GREEN;
    /**
     * 大小
     */
    private final Size size = Size.MEDIUM;
    /**
     * 价格
     */
    private final Double price = 10.0;


    public Watermelon() {
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
