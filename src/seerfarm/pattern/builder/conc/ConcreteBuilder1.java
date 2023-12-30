package seerfarm.pattern.builder.conc;

import seerfarm.common.FarmGrowth;
import seerfarm.common.product.AbstractSeed;
import seerfarm.common.product.fertilizer.AdvancedFertilizer;
import seerfarm.pattern.builder.Builder;

/**
 * 具体建造者1
 */
public class ConcreteBuilder1 extends Builder {
    @Override
    public void buildPlant(AbstractSeed seed) {
        FarmGrowth.loosenSoil();
        FarmGrowth.plantSeed(seed, farmBlock);
        FarmGrowth.watering(farmBlock);
        FarmGrowth.weed(farmBlock);
        FarmGrowth.applyFertilizer(new AdvancedFertilizer(), farmBlock);
    }
}
