package SpaceGreenhouse.common.status.product;

/**
 * 太空温室块的形状
 */
public enum Shape {
    SQUARE("圆形"),
    CIRCULAR("方形");
    private String shape;

    Shape(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
}
