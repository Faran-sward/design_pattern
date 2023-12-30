package seerfarm.test.iterator;

import seerfarm.common.seerfarm;
import seerfarm.pattern.iterator.conc.FarmIterator;

public class IteratorTest {
    public static void test(){
        seerfarm farm = seerfarm.getInstance();
        FarmIterator iterator = farm.getIterator();
        System.out.println(iterator.first());
        System.out.println("----调用迭代器模式ing----");
        System.out.println("为您迭代输出所有农田块的信息");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void main(String[] args) {
        test();

    }
}
