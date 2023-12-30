package seerfarm.common;

import seerfarm.common.product.AbstractCrops;
import seerfarm.common.product.AbstractFertilizer;
import seerfarm.common.product.AbstractSeed;
import seerfarm.pattern.adapter.conc.seerAdapter;

/**
 * 商店类
 * 仓库从商店买入种子、肥料
 * 仓库卖出作物到商店
 */
public class Shop {

    private seerAdapter SEER=seerAdapter.getInstance();

    private seerfarmWarehouse seerfarmWarehouse= SEER.getFarmWarehouse();

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
        return seerfarmWarehouse.buySeeds(seed, num);
    }

    /**
     * 购买肥料
     * @param fertilizer
     * @param num
     * @return
     */
    public boolean buyFertilizer(AbstractFertilizer fertilizer, int num) {
        return seerfarmWarehouse.buyFertilizer(fertilizer, num);
    }

    /**
     * 售卖作物
     * @param crops
     * @param num
     * @return
     */
    public boolean sellCrops(AbstractCrops crops, int num) {
        return seerfarmWarehouse.sellCrops(crops, num);
    }
}
