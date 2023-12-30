package seerfarm.common.farm;

import seerfarm.common.product.AbstractCrops;
import seerfarm.common.product.AbstractSeed;

import java.util.Map;

/**
 * 定义农场行为
 */
public interface IFarm {
    /**
     * 一键种植种子
     *
     * @param seed
     */
    void plantBatchSeeds(AbstractSeed seed);

    /**
     * 一键收获作物
     */
    Map<AbstractCrops,Integer> harvestBatchSeeds();
}
