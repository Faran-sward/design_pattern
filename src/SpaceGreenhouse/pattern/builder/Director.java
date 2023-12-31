package SpaceGreenhouse.pattern.builder;

import SpaceGreenhouse.common.SpaceGreenhouseBlock;
import SpaceGreenhouse.common.product.AbstractSeed;

public class Director {
    private Builder builder;

    private SpaceGreenhouseBlock SpaceGreenhouseBlock;

    public Director(Builder builder, SpaceGreenhouseBlock SpaceGreenhouseBlock) {
        this.builder = builder;
        this.SpaceGreenhouseBlock = SpaceGreenhouseBlock;
    }
    
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void setSpaceGreenhouseBlock(SpaceGreenhouseBlock SpaceGreenhouseBlock) {
        this.SpaceGreenhouseBlock = SpaceGreenhouseBlock;
    }

    public void getSpaceGreenhouseBlock(AbstractSeed seed) {
        //要先初始化太空温室块
        builder.setSpaceGreenhouseBlock(SpaceGreenhouseBlock);
        builder.buildPlant(seed);
    }
}
