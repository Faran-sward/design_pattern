package seerGame.diggingpackage.template;

import seerGame.mementopackage.RecordList;
import seerGame.mementopackage.ScoreOriginator;
import singletonlazyinitialization.SEERManor;

import java.util.Random;

/**
 * @author raoji
 * @date 2023/12/30
 * @Description
 */

public class DepthDiggging extends AbstractDigging{
    public DepthDiggging(){
        super(2);
    }

    @Override
    protected boolean checkTicket(int ticket){
        System.out.println("正在检票......");
        if(ticket==0) {
            System.out.println("票数不足，无法参加下潜挖矿活动，请先购买票！！");

            return false;
        }
        else{
            ticket--;
            System.out.println("检票成功！\n目前剩余票数为：" + ticket);
            return true;
        }
    }

    @Override
    protected void diggingProcess(int Score) {
        System.out.println("\n 采集开始！");
        Random random=new Random();
        int r=0;
        for(int i=0;i<3;i++) {
            try {
                System.out.println("小赛尔["+ SEERManor.getPlayer().getSEERName() +"]开始采集！！");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int RowScore = 0;
            for(int j = 0;j < 3; j++){
                r = random.nextInt(5) % 4;
                if (r == 0) {
                    Score++;
                    RowScore++;
                    score(Score);
                    System.out.println("小赛尔["+SEERManor.getPlayer().getSEERName()+"]成功采集到矿石！！");
                    break;
                } else
                    System.out.println("小赛尔["+SEERManor.getPlayer().getSEERName()+"]未采集到矿石！！");
            }
            if(RowScore == 0)
                break;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected int getScore(int Score) {
        if(Score != 0){
            System.out.println("\n"+"小摩尔[" + SEERManor.getPlayer().getSEERName()+"]");
            System.out.println("小摩尔[" + SEERManor.getPlayer().getSEERName()+"]的最终获得的矿石数为："+Score+"（一次最多采集三个）");
        }
        else{
            System.out.println("\n" + "小赛尔本次未采集到矿石，下次再努力哦！");
        }


        /**
         * 添加备忘录
         */
        ScoreOriginator scoreOriginator = new ScoreOriginator();
        scoreOriginator.setRecord(Score,"泰坦矿石");
        RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());

        return Score;
    }
}
