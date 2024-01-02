package SpaceGreenhouse.pattern.command.conc;

import SpaceGreenhouse.Home;
import SpaceGreenhouse.common.SpaceGreenhouseWarehouse;
import SpaceGreenhouse.common.exception.product.conc.FertilizerNotFoundException;
import SpaceGreenhouse.common.product.AbstractFertilizer;
import SpaceGreenhouse.common.utils.JsonOp;
import SpaceGreenhouse.pattern.adapter.conc.SeerAdapter;
import SpaceGreenhouse.pattern.command.Command;
import SpaceGreenhouse.pattern.factory.conc.FertilizerFactory;

import java.util.Map;

/**
 * 具体命令
 * 仓库向商店发生请求，进货肥料
 */
public class FertilizerCommand implements Command {
    private FertilizerFactory fertilizerFactory = FertilizerFactory.newInstance();
    /**
     * 命令接收方，仓库
     */
    private SpaceGreenhouseWarehouse SpaceGreenhouseWarehouse = SeerAdapter.getInstance().getSpaceGreenhouseWarehouse();

    public void setSpaceGreenhouseWarehouse(SpaceGreenhouseWarehouse SpaceGreenhouseWarehouse) {
        this.SpaceGreenhouseWarehouse = SpaceGreenhouseWarehouse;
    }

    /**
     * 商店接收命令，为仓库买入肥料
     *
     * @param name
     * @param num
     */

    public boolean execute(String name, int num) {
        AbstractFertilizer fertilizer =null;
        try{
            fertilizer = fertilizerFactory.create(Home.fertilizerMap.get(name));
        } catch (FertilizerNotFoundException e){e.printStackTrace();}
        return SpaceGreenhouseWarehouse.buyFertilizer(fertilizer, num);
    }

}
