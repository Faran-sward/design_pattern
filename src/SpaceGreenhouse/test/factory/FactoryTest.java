package SpaceGreenhouse.test.factory;

import SpaceGreenhouse.Home;
import SpaceGreenhouse.common.exception.product.conc.CropsNotFoundException;
import SpaceGreenhouse.common.exception.product.conc.SeedNotFoundException;
import SpaceGreenhouse.common.product.AbstractCrops;
import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.common.utils.JsonOp;
import SpaceGreenhouse.pattern.factory.conc.CropsFactory;
import SpaceGreenhouse.pattern.factory.conc.SeedFactory;

import java.util.Map;

public class FactoryTest {

    private static SeedFactory seedFactory=SeedFactory.newInstance();

    private static CropsFactory cropsFactory=CropsFactory.newInstance();

    public static void produceSeed(String seedName){
        System.out.println("----调用工厂模式ing----");
        String name= Home.seedMap.get(seedName);
        try {
            AbstractSeed seed = seedFactory.create(name);
            System.out.println("种子工厂正在生产"+seedName+"...");
            System.out.println("种子名称："+seed.getName());
            System.out.println("种子价格："+seed.getPrice());
            System.out.println("种子颜色："+seed.getColor());
            System.out.println("种子生产周期"+seed.getGrowthCycle());
        } catch (SeedNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("-------------------------");
        }
    }

    private static void produceCrops(String cropsName){
        String name=Home.seedMap.get(cropsName);
        try {
            AbstractCrops crops = cropsFactory.create(name);
            System.out.println("种子工厂正在生产"+cropsName+"...");
            System.out.println("作物名称："+crops.getName());
            System.out.println("作物价格："+crops.getPrice());
            System.out.println("作物颜色："+crops.getColor());
        } catch (CropsNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("-------------------------");
        }
    }

    public static void main(String[] args) {
        String seedName="草莓种子";

        produceSeed(seedName);

        String cropsName="西瓜";

        produceCrops(cropsName);
    }
}
