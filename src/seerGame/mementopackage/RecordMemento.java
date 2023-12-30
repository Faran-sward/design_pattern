package seerGame.mementopackage;

import  java.util.Date;

/**
 * @author raoji
 * @date 2023/12/30
 * @Description
 */
public class RecordMemento {
    private int score;
    private String gameName;
    private String date;

    public RecordMemento(int score, String gameName){
        this.score = score;
        this.gameName = gameName;
        this.date = new Date().toString();
    }
    /**
     * 获取分数
     * @return score
     */
    public int getScore(){
        return score;
    }
    /**
     * 获取游戏名称
     * @return gameName
     */
    public String getName(){
        return gameName;
    }
    /**
     * 获取游戏时间
     * @return gameName
     */
    public String getDate(){
        return date;
    }
}
