package SpaceGreenhouse.pattern.builder.conc;

import SpaceGreenhouse.common.SpaceGreenhouseGrowth;
import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.common.product.fertilizer.AdvancedFertilizer;
import SpaceGreenhouse.pattern.builder.Builder;

/**
 * 具体建造者1
 */
public class ConcreteBuilder1 extends Builder {
    @Override
    public void buildPlant(AbstractSeed seed) {
        SpaceGreenhouseGrowth.loosenSoil();
        SpaceGreenhouseGrowth.plantSeed(seed, SpaceGreenhouseBlock);
        SpaceGreenhouseGrowth.watering(SpaceGreenhouseBlock);
        SpaceGreenhouseGrowth.weed(SpaceGreenhouseBlock);
        SpaceGreenhouseGrowth.applyFertilizer(new AdvancedFertilizer(), SpaceGreenhouseBlock);
    }
}
