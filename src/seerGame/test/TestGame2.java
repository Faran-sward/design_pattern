package seerGame.test;

import seerGame.Game;
import seerGame.mementopackage.RecordList;
import seerGame.mementopackage.ScoreOriginator;

/**
 * @author raoji
 * @date 2023/12/30
 * @Description
 */
public class TestGame2 implements Game {
    @Override
    public void Play() {
        System.out.println("playing game2...");
        ScoreOriginator scoreOriginator = new ScoreOriginator();
        scoreOriginator.setRecord(100,"game2");
        RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());
    }
}
