package moleSpaceGreenhouse.pattern.command.conc;

import moleSpaceGreenhouse.Home;
import moleSpaceGreenhouse.common.SpaceGreenhouseWarehouse;
import moleSpaceGreenhouse.common.exception.product.conc.FertilizerNotFoundException;
import moleSpaceGreenhouse.common.product.AbstractFertilizer;
import moleSpaceGreenhouse.common.utils.JsonOp;
import moleSpaceGreenhouse.pattern.adapter.conc.SeerAdapter;
import moleSpaceGreenhouse.pattern.command.Command;
import moleSpaceGreenhouse.pattern.factory.conc.FertilizerFactory;

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
