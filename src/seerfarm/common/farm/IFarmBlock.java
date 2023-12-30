package seerfarm.common.farm;

import seerfarm.common.product.AbstractCrops;
import seerfarm.common.product.AbstractSeed;

/**
 * 这个类是由seerfarmBlock实现的
 * 但是plantSeed需要保留，调用的是IFarmBlock的plantSeed
 */
public interface IFarmBlock {
    /**
     * 种植
     */
    void plantSeed(AbstractSeed seed);
    /**
     * 收获作物
     */
    AbstractCrops harvestCrops();
}
