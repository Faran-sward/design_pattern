package SpaceGreenhouse.common.status.other;

/**
 * 太空温室物品的种类
 */
public enum ProductType {
    CROPS("crops"), SEED("seed"), SpaceGreenhouse_TOOL("SpaceGreenhouseTool"), FERTILIZER("fertilizer");
    String text;

    ProductType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
