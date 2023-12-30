package seerfarm.pattern.builder.conc;

import seerfarm.common.FarmGrowth;
import seerfarm.common.product.AbstractSeed;
import seerfarm.common.product.fertilizer.PrimaryFertilizer;
import seerfarm.pattern.builder.Builder;

/**
 * 具体建造者2
 */
public class ConcreteBuilder2 extends Builder {
    @Override
    public void buildPlant(AbstractSeed seed) {
        FarmGrowth.plantSeed(seed, farmBlock);
        FarmGrowth.applyFertilizer(new PrimaryFertilizer(), farmBlock);
    }

}
