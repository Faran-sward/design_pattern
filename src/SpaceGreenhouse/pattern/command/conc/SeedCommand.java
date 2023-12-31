package SpaceGreenhouse.pattern.command.conc;

import SpaceGreenhouse.Home;
import SpaceGreenhouse.common.SpaceGreenhouseWarehouse;
import SpaceGreenhouse.common.exception.product.conc.SeedNotFoundException;
import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.common.utils.JsonOp;
import SpaceGreenhouse.pattern.adapter.conc.SeerAdapter;
import SpaceGreenhouse.pattern.command.Command;
import SpaceGreenhouse.pattern.factory.conc.SeedFactory;

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
    private SpaceGreenhouseWarehouse SpaceGreenhouseWarehouse = SeerAdapter.getInstance().getSpaceGreenhouseWarehouse();

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
        return SpaceGreenhouseWarehouse.buySeeds(seed, num);
    }
}
