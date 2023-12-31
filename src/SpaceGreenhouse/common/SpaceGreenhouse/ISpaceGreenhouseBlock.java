package SpaceGreenhouse.common.SpaceGreenhouse;

import SpaceGreenhouse.common.product.AbstractCrops;
import SpaceGreenhouse.common.product.AbstractSeed;

/**
 * 这个类是由SpaceGreenhouseBlock实现的
 * 但是plantSeed需要保留，调用的是ISpaceGreenhouseBlock的plantSeed
 */
public interface ISpaceGreenhouseBlock {
    /**
     * 种植
     */
    void plantSeed(AbstractSeed seed);
    /**
     * 收获作物
     */
    AbstractCrops harvestCrops();
}
