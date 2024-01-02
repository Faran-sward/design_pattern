package SpaceGreenhouse.test.iterator;

import SpaceGreenhouse.common.SpaceGreenhouse;
import SpaceGreenhouse.pattern.iterator.conc.SpaceGreenhouseIterator;

public class IteratorTest {
    public static void test(){
        SpaceGreenhouse spaceGreenhouse = SpaceGreenhouse.getInstance();
        SpaceGreenhouseIterator iterator = spaceGreenhouse.getIterator();
        System.out.println(iterator.first());
        System.out.println("----调用迭代器模式ing----");
        System.out.println("为您迭代输出所有太空温室块的信息");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void main(String[] args) {
        test();

    }
}
