package SpaceGreenhouse.pattern.builder.conc;

import SpaceGreenhouse.common.SpaceGreenhouseGrowth;
import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.common.product.fertilizer.PrimaryFertilizer;
import SpaceGreenhouse.pattern.builder.Builder;

/**
 * 具体建造者2
 */
public class ConcreteBuilder2 extends Builder {
    @Override
    public void buildPlant(AbstractSeed seed) {
        SpaceGreenhouseGrowth.plantSeed(seed, SpaceGreenhouseBlock);
        SpaceGreenhouseGrowth.applyFertilizer(new PrimaryFertilizer(), SpaceGreenhouseBlock);
    }

}
