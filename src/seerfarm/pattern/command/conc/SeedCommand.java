package seerfarm.pattern.command.conc;

import seerfarm.Home;
import seerfarm.common.SeerFarmWarehouse;
import seerfarm.common.exception.product.conc.SeedNotFoundException;
import seerfarm.common.product.AbstractSeed;
import seerfarm.common.utils.JsonOp;
import seerfarm.pattern.adapter.conc.SeerAdapter;
import seerfarm.pattern.command.Command;
import seerfarm.pattern.factory.conc.SeedFactory;

import java.util.Map;

/**
 * 具体命令
 * 仓库发送请求，从商店进货种子
 */
public class SeedCommand implements Command {
    private SeedFactory seedFactory = SeedFactory.newInstance();
    /**
     * 命令接收方，仓库
     */
    private SeerFarmWarehouse seerFarmWarehouse = SeerAdapter.getInstance().getFarmWarehouse();

    /**
     * 商店接收命令，为仓库买入种子
     *
     * @param name
     * @param num
     */
    public boolean execute(String name, int num) {
        AbstractSeed seed =null;
        try{
            seed = seedFactory.create(Home.seedMap.get(name));
        } catch (SeedNotFoundException e){e.printStackTrace();}
        return seerFarmWarehouse.buySeeds(seed, num);
    }
}
