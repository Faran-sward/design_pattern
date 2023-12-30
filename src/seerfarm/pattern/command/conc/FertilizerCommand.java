package seerfarm.pattern.command.conc;

import seerfarm.Home;
import seerfarm.common.seerfarmWarehouse;
import seerfarm.common.exception.product.conc.FertilizerNotFoundException;
import seerfarm.common.product.AbstractFertilizer;
import seerfarm.common.utils.JsonOp;
import seerfarm.pattern.adapter.conc.seerAdapter;
import seerfarm.pattern.command.Command;
import seerfarm.pattern.factory.conc.FertilizerFactory;

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
    private seerfarmWarehouse seerfarmWarehouse = seerAdapter.getInstance().getFarmWarehouse();

    public void setseerfarmWarehouse(seerfarmWarehouse seerfarmWarehouse) {
        this.seerfarmWarehouse = seerfarmWarehouse;
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
        return seerfarmWarehouse.buyFertilizer(fertilizer, num);
    }

}
