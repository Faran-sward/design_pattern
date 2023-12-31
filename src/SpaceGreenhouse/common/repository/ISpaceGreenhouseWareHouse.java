package SpaceGreenhouse.common.repository;

import SpaceGreenhouse.common.product.AbstractCrops;
import SpaceGreenhouse.common.product.AbstractFertilizer;
import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.common.product.IProduct;

import java.util.List;
import java.util.Map;

/**
 * 定义仓库的行为
 */
interface ISpaceGreenhouseWareHouse {
    /**
     * 从商店买种子
     *
     * @param seed
     * @param num
     * @return
     */
    boolean buySeeds(AbstractSeed seed, int num);

    /**
     * 从商店买肥料
     *
     * @param fertilizer
     * @param num
     * @return
     */
    boolean buyFertilizer(AbstractFertilizer fertilizer, int num);

    /**
     * 出口作物到商店
     *
     * @param crops
     * @param num
     * @return
     */
    boolean sellCrops(AbstractCrops crops, int num);

    /**
     * 给赛尔提供需要的东西
     *
     * @param objectList
     * @return
     */
    <T extends IProduct> boolean provideItemToSEER(List<T> objectList);

    /**
     * 存作物到仓库
     * @param otherCropsMap
     * @return
     */
    boolean storeToRepository(Map<AbstractCrops,Integer> otherCropsMap);
}
