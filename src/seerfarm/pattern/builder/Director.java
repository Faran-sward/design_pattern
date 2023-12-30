package seerfarm.pattern.builder;

import seerfarm.common.SeerFarmBlock;
import seerfarm.common.product.AbstractSeed;

public class Director {
    private Builder builder;

    private SeerFarmBlock farmBlock;

    public Director(Builder builder, SeerFarmBlock farmBlock) {
        this.builder = builder;
        this.farmBlock = farmBlock;
    }
    
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void setFarmBlock(SeerFarmBlock farmBlock) {
        this.farmBlock = farmBlock;
    }

    public void getSeerFarmBlock(AbstractSeed seed) {
        //要先初始化农田块
        builder.setFarmBlock(farmBlock);
        builder.buildPlant(seed);
    }
}
