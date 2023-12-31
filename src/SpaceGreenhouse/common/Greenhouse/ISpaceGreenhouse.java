package SpaceGreenhouse.common.Greenhouse;

import SpaceGreenhouse.common.product.AbstractCrops;
import SpaceGreenhouse.common.product.AbstractSeed;

import java.util.Map;

/**
 * 定义农场行为
 */
public interface ISpaceGreenhouse {
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
