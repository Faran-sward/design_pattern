package SpaceGreenhouse.pattern.builder;

import SpaceGreenhouse.common.SpaceGreenhouseBlock;
import SpaceGreenhouse.common.product.AbstractSeed;

/**
 * 到时候在使用建造者模式的时候，分为一键种植（只是松土加种植），一键种植（加上浇水和施肥），一键收获
 * 这里是选用不同的建造者，实现不同的种植模式，一个好，一个坏，但是种植的过程都被隐藏起来了
 */
public abstract class Builder {

    protected SpaceGreenhouseBlock SpaceGreenhouseBlock;

    /**
     * 种植一个具体的种子
     *
     * @param seed
     */
    public abstract void buildPlant(AbstractSeed seed);

    public void setSpaceGreenhouseBlock(SpaceGreenhouseBlock SpaceGreenhouseBlock) {
        this.SpaceGreenhouseBlock = SpaceGreenhouseBlock;
    }

    public SpaceGreenhouseBlock getSpaceGreenhouseBlock() {
        return SpaceGreenhouseBlock;
    }
}
