package seerfarm.test.factory;

import seerfarm.Home;
import seerfarm.common.exception.product.conc.CropsNotFoundException;
import seerfarm.common.exception.product.conc.SeedNotFoundException;
import seerfarm.common.product.AbstractCrops;
import seerfarm.common.product.AbstractSeed;
import seerfarm.common.utils.JsonOp;
import seerfarm.pattern.factory.conc.CropsFactory;
import seerfarm.pattern.factory.conc.SeedFactory;

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
