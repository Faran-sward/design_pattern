package SpaceGreenhouse;

import SpaceGreenhouse.common.Shop;
import SpaceGreenhouse.common.utils.JsonOp;
import SpaceGreenhouse.pattern.factory.conc.CropsFactory;
import SpaceGreenhouse.pattern.factory.conc.FertilizerFactory;
import SpaceGreenhouse.pattern.factory.conc.SeedFactory;
import SpaceGreenhouse.pattern.factory.conc.ToolFactory;

import java.util.Map;

public class Home {

    public static Shop shop = Shop.getInstance();

    public static SeedFactory seedFactory = SeedFactory.newInstance();

    public static CropsFactory cropsFactory = CropsFactory.newInstance();

    public static FertilizerFactory fertilizerFactory = FertilizerFactory.newInstance();

    public static ToolFactory toolFactory = ToolFactory.newInstance();

    public static final Map<String, String> seedMap = JsonOp.searchMapper("Seed");

    public static final Map<String, String> cropsMap = JsonOp.searchMapper("Crops");

    public static final Map<String, String> fertilizerMap = JsonOp.searchMapper("Fertilizer");

    public static final Map<String, String> toolMap = JsonOp.searchMapper("Tool");

}
