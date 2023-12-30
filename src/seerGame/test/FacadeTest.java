package seerGame.test;

import seerGame.GameMaker;

/**
 * @author raoji
 * @date 2023/12/30
 * @Description
 */
public class FacadeTest {

    /**
     * @test
     */
    public static void test(){
        System.out.println("----调用外观模式ing----");

        GameMaker.getInstance().playtestGame1();
        GameMaker.getInstance().playtestGame2();
    }

    public static void main(String[] args) {
        FacadeTest.test();
    }
}
