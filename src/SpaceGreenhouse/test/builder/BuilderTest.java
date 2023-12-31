package SpaceGreenhouse.test.builder;

import SpaceGreenhouse.Home;
import SpaceGreenhouse.common.SpaceGreenhouseGrowth;
import SpaceGreenhouse.common.SpaceGreenhouseBlock;
import SpaceGreenhouse.common.exception.product.conc.SeedNotFoundException;
import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.common.utils.JsonOp;
import SpaceGreenhouse.pattern.adapter.conc.WeatherAdapter;
import SpaceGreenhouse.pattern.builder.Builder;
import SpaceGreenhouse.pattern.builder.Director;
import SpaceGreenhouse.pattern.builder.conc.ConcreteBuilder1;
import SpaceGreenhouse.pattern.builder.conc.ConcreteBuilder2;
import SpaceGreenhouse.pattern.factory.conc.SeedFactory;

import java.util.Map;

//false
public class BuilderTest {

    static {
        WeatherAdapter.adapter=WeatherAdapter.changeWeather();
        System.out.println("农场今日天气为："+WeatherAdapter.changeWeather().getWeather());
    }

    public static AbstractSeed createSeed(String seedName){
        AbstractSeed seed=null;
        try {
             seed= SeedFactory.newInstance().create(Home.seedMap.get(seedName));
        } catch (SeedNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return seed;
    }
    public static void builder1(SpaceGreenhouseBlock block, AbstractSeed seed){
        Builder builder1 = new ConcreteBuilder1();

        Director director=new Director(builder1,block);

        System.out.println("----原本的状态----");
        block.getInfo();

        System.out.println("----使用建造者模式ing----");
        director.getSpaceGreenhouseBlock(seed);

        System.out.println("----后来的状态----");
        block.getInfo();

    }

    private static void builder2(SpaceGreenhouseBlock block,AbstractSeed seed) {
        Builder builder2 = new ConcreteBuilder2();

        Director director = new Director(builder2, block);

        System.out.println("----原本的状态----");
        block.getInfo();

        System.out.println("----使用建造者模式ing----");
        director.getSpaceGreenhouseBlock(seed);

        System.out.println("----后来的状态----");
        block.getInfo();

    }

    public static void main(String[] args) {
        SpaceGreenhouseBlock block1 = new SpaceGreenhouseBlock();

        String name="白菜种子";
        AbstractSeed seed = createSeed(name);
        //具体建造者1
        builder1(block1,seed);

        SpaceGreenhouseBlock block2 = new SpaceGreenhouseBlock();

        String name1="草莓种子";
        AbstractSeed seed1 = createSeed(name1);

        System.out.print("\n");
        //具体建造者2
        builder2(block2,seed1);

    }
}
