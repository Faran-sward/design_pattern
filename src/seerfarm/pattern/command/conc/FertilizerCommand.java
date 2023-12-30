package molefarm.pattern.command.conc;

import molefarm.Home;
import molefarm.common.SeerFarmWarehouse;
import molefarm.common.exception.product.conc.FertilizerNotFoundException;
import molefarm.common.product.AbstractFertilizer;
import molefarm.common.utils.JsonOp;
import molefarm.pattern.adapter.conc.SeerAdapter;
import molefarm.pattern.command.Command;
import molefarm.pattern.factory.conc.FertilizerFactory;

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
    private SeerFarmWarehouse seerFarmWarehouse = SeerAdapter.getInstance().getFarmWarehouse();

    public void setSeerFarmWarehouse(SeerFarmWarehouse seerFarmWarehouse) {
        this.seerFarmWarehouse = seerFarmWarehouse;
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
        return seerFarmWarehouse.buyFertilizer(fertilizer, num);
    }

}