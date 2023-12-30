package seerfarm.test.builder;

import seerfarm.Home;
import seerfarm.common.FarmGrowth;
import seerfarm.common.seerfarmBlock;
import seerfarm.common.exception.product.conc.SeedNotFoundException;
import seerfarm.common.product.AbstractSeed;
import seerfarm.common.utils.JsonOp;
import seerfarm.pattern.adapter.conc.WeatherAdapter;
import seerfarm.pattern.builder.Builder;
import seerfarm.pattern.builder.Director;
import seerfarm.pattern.builder.conc.ConcreteBuilder1;
import seerfarm.pattern.builder.conc.ConcreteBuilder2;
import seerfarm.pattern.factory.conc.SeedFactory;

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
    public static void builder1(seerfarmBlock block, AbstractSeed seed){
        Builder builder1 = new ConcreteBuilder1();

        Director director=new Director(builder1,block);

        System.out.println("----原本的状态----");
        block.getInfo();

        System.out.println("----使用建造者模式ing----");
        director.getseerfarmBlock(seed);

        System.out.println("----后来的状态----");
        block.getInfo();

    }

    private static void builder2(seerfarmBlock block,AbstractSeed seed) {
        Builder builder2 = new ConcreteBuilder2();

        Director director = new Director(builder2, block);

        System.out.println("----原本的状态----");
        block.getInfo();

        System.out.println("----使用建造者模式ing----");
        director.getseerfarmBlock(seed);

        System.out.println("----后来的状态----");
        block.getInfo();

    }

    public static void main(String[] args) {
        seerfarmBlock block1 = new seerfarmBlock();

        String name="白菜种子";
        AbstractSeed seed = createSeed(name);
        //具体建造者1
        builder1(block1,seed);

        seerfarmBlock block2 = new seerfarmBlock();

        String name1="草莓种子";
        AbstractSeed seed1 = createSeed(name1);

        System.out.print("\n");
        //具体建造者2
        builder2(block2,seed1);

    }
}
