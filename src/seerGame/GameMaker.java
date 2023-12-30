package seerGame;

import seerGame.commoditypackage.Shopping;
import seerGame.diggingpackage.Digging;
import seerGame.test.TestGame1;
import seerGame.test.TestGame2;


//外观模式
public class GameMaker {

    private Game shopping;
    private Game digging;

    /**
     * 测试用例
     */
    private Game testGame1;
    private Game testGame2;


    private static GameMaker instance=new GameMaker();
    public static GameMaker getInstance(){return instance;}
    public GameMaker() {
        digging = new Digging();
        shopping = new Shopping();

        //测试
        testGame1 = new TestGame1();
        testGame2 = new TestGame2();
    }

    //商店接口
    public void playShopping(){
        shopping.Play();
    }

    //挖矿接口
    public void playDigging(){
        digging.Play();
    }


    /**
     * 测试用例
     */
    public void playtestGame1(){
        testGame1.Play();
    }
    public void playtestGame2(){
        testGame2.Play();
    }


}

