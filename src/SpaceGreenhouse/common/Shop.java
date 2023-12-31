package SpaceGreenhouse.common;

import SpaceGreenhouse.common.product.AbstractCrops;
import SpaceGreenhouse.common.product.AbstractFertilizer;
import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.pattern.adapter.conc.SeerAdapter;
import SpaceGreenhouse.pattern.adapter.conc.SeerAdapter;

/**
 * 商店类
 * 仓库从商店买入种子、肥料
 * 仓库卖出作物到商店
 */
public class Shop {

    private SeerAdapter SEER=SeerAdapter.getInstance();

    private SpaceGreenhouseWarehouse SpaceGreenhouseWarehouse= SEER.getSpaceGreenhouseWarehouse();

    //关联商店与仓库
    private Shop() {
    }

    public static Shop getInstance() {
        return new Shop();
    }

    /**
     * 购买种子
     * @param seed
     * @param num
     * @return
     */
    public boolean buySeeds(AbstractSeed seed, int num) {
        return SpaceGreenhouseWarehouse.buySeeds(seed, num);
    }

    /**
     * 购买肥料
     * @param fertilizer
     * @param num
     * @return
     */
    public boolean buyFertilizer(AbstractFertilizer fertilizer, int num) {
        return SpaceGreenhouseWarehouse.buyFertilizer(fertilizer, num);
    }

    /**
     * 售卖作物
     * @param crops
     * @param num
     * @return
     */
    public boolean sellCrops(AbstractCrops crops, int num) {
        return SpaceGreenhouseWarehouse.sellCrops(crops, num);
    }
}
