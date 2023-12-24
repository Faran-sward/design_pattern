package framework.test;

import framework.interpreter.BuyTicket;
import framework.simplefactory.SEER;
import singletonlazyinitialization.SEERManor;

public class InterpreterTest {
    /**
     * @test
     */
    public static void test(){
        System.out.println("----调用解释器模式ing----");

        SEERManor seerManor= SEERManor.getInstance();
        seerManor.test();
        SEER seer= SEERManor.getPlayer();
        BuyTicket by = new BuyTicket(seer);
        by.changeTicket(1);
    }

    public static void main(String []args){
        InterpreterTest.test();
    }
}
