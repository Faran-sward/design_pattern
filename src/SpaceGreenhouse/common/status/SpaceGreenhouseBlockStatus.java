package SpaceGreenhouse.common.status;

/**
 * 太空温室块的状态
 */
public enum SpaceGreenhouseBlockStatus {
    WEEDS("杂草"),
    INSECT_DISASTER("长虫"),
    DROUGHT("干旱");
    String text;

    SpaceGreenhouseBlockStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
