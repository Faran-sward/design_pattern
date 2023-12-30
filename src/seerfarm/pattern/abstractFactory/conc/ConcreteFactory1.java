package seerfarm.pattern.abstractFactory.conc;

import seerfarm.Home;
import seerfarm.common.exception.factory.FactoryNotFoundException;
import seerfarm.common.exception.product.FactoryNotProduceException;
import seerfarm.common.exception.product.conc.CropsNotFoundException;
import seerfarm.common.exception.product.conc.FertilizerNotFoundException;
import seerfarm.common.exception.product.conc.SeedNotFoundException;
import seerfarm.common.exception.product.conc.ToolNotFoundException;
import seerfarm.common.product.AbstractCrops;
import seerfarm.common.product.AbstractFertilizer;
import seerfarm.common.product.AbstractSeed;
import seerfarm.common.product.AbstractTool;
import seerfarm.pattern.abstractFactory.IFactory;
import seerfarm.pattern.factory.conc.CropsFactory;
import seerfarm.pattern.factory.conc.FertilizerFactory;
import seerfarm.pattern.factory.conc.SeedFactory;
import seerfarm.pattern.factory.conc.ToolFactory;

import java.util.Arrays;
import java.util.List;

/**
 * 具体生产种子，肥料，农具的工厂
 * 生产白菜、草莓、水稻的作物及种子
 * 生产高级肥料
 * 生产水壶和镰刀
 * 此类生产产品去seerFarm.pattern.factory.conc下的对应工厂调用方法
 */
public class ConcreteFactory1 implements IFactory {
    private final List<String> cropsList = Arrays.asList("Cabbage", "Strawberry", "Rice");
    private final List<String> seedList = Arrays.asList("CabbageSeed", "StrawberrySeed", "RiceSeed");
    private final List<String> fertilizerList = Arrays.asList("AdvancedFertilizer");
    private final List<String> toolList = Arrays.asList("WateringCan", "Sick");
    private final CropsFactory cropsFactory = Home.cropsFactory;
    private final SeedFactory seedFactory = Home.seedFactory;
    private final FertilizerFactory fertilizerFactory = Home.fertilizerFactory;
    private final ToolFactory toolFactory = Home.toolFactory;

    public static ConcreteFactory1 newInstance() throws FactoryNotFoundException {
        return IFactory.newConcreteFactory("ConcreteFactory1");
    }

    @Override
    public AbstractCrops createCrops(String name) throws FactoryNotProduceException {
        if (cropsList.contains(name)) {
            try {
                return cropsFactory.create(name);
            } catch (CropsNotFoundException e) {
                e.printStackTrace();
            }
        }
        throw new FactoryNotProduceException("此工厂不生产该作物");
    }

    @Override
    public AbstractSeed createSeed(String name) throws FactoryNotProduceException {
        if (seedList.contains(name)) {
            try {
                return seedFactory.create(name);
            } catch (SeedNotFoundException e) {
                e.printStackTrace();
            }
        }
        throw new FactoryNotProduceException("此工厂不生产该种子");
    }

    @Override
    public AbstractFertilizer createFertilier(String name) throws FactoryNotProduceException {
        if (fertilizerList.contains(name)) {
            try {
                return fertilizerFactory.create(name);
            } catch (FertilizerNotFoundException e) {
                e.printStackTrace();
            }
        }
        throw new FactoryNotProduceException("此工厂不生产该肥料");
    }

    @Override
    public AbstractTool createTool(String name) throws FactoryNotProduceException {
        if (toolList.contains(name)) {
            try {
                return toolFactory.create(name);
            } catch (ToolNotFoundException e) {
                e.printStackTrace();
            }
        }
        throw new FactoryNotProduceException("此工厂不生产该工具");
    }
}
