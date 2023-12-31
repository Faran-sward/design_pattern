package SpaceGreenhouse.pattern.chainOfResponsibility.conc;

import SpaceGreenhouse.common.product.AbstractFertilizer;
import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.common.product.IProduct;
import SpaceGreenhouse.pattern.chainOfResponsibility.Handler;

import java.util.List;

/**
 * 仓库
 * 任务接收者
 */
public class WareHouseHandler extends Handler {
    @Override
    public <T extends IProduct> boolean provideSeeds(List<T> list) {
        for (T item : list) {
            int num = item instanceof AbstractSeed ? SpaceGreenhouseWarehouse.getSeedMap().get(item) : SpaceGreenhouseWarehouse.getFertilizerMap().get(item);
            if (num == 0) {
                System.out.println("抱歉，仓库的" + item.getName() + "数量不足，正在为您向仓库进货......");
                return getNext().provideSeeds(list);
            }
            //仓库存量减1
            else {
                if (item instanceof AbstractSeed) {
                    SpaceGreenhouseWarehouse.getSeedMap().put((AbstractSeed) item, num - 1);
                } else {

                    SpaceGreenhouseWarehouse.getFertilizerMap().put((AbstractFertilizer) item, num - 1);
                }
            }
        }
        return true;
    }
}
