package seerfarm.pattern.builder;

import seerfarm.common.seerfarmBlock;
import seerfarm.common.product.AbstractSeed;

public class Director {
    private Builder builder;

    private seerfarmBlock farmBlock;

    public Director(Builder builder, seerfarmBlock farmBlock) {
        this.builder = builder;
        this.farmBlock = farmBlock;
    }
    
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void setFarmBlock(seerfarmBlock farmBlock) {
        this.farmBlock = farmBlock;
    }

    public void getseerfarmBlock(AbstractSeed seed) {
        //要先初始化农田块
        builder.setFarmBlock(farmBlock);
        builder.buildPlant(seed);
    }
}
