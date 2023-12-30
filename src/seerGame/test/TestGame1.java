package seerGame.test;

/**
 * @author raoji
 * @date 2023/12/30
 * @Description
 */

import seerGame.Game;
import seerGame.mementopackage.RecordList;
import seerGame.mementopackage.ScoreOriginator;

public class TestGame1 implements Game {
    @Override
    public void Play() {
        System.out.println("playing game1...");
        ScoreOriginator scoreOriginator = new ScoreOriginator();
        scoreOriginator.setRecord(10,"game1");
        RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());
    }

}

