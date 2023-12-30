package seerGame.test;

import seerGame.GameMaker;
import seerGame.mementopackage.RecordList;
import seerGame.mementopackage.ScoreOriginator;
import singletonlazyinitialization.SEERManor;

/**
 * @author raoji
 * @date 2023/12/30
 * @Description
 */
public class GameTestDemo {

    public static void main(String[] args) {

        SEERManor seer = SEERManor.getInstance();
        seer.test();

        ScoreOriginator scoreOriginator = new ScoreOriginator();
        RecordList pointRecordList = RecordList.getInstance();
        GameMaker gameMaker = new GameMaker();


        gameMaker.playDigging();

        gameMaker.playShopping();


        System.out.println("\n开始打印得分备忘录内容...");
        pointRecordList.printList();
    }
}
