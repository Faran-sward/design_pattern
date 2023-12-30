package seerGame.diggingpackage.template;

import seerGame.mementopackage.RecordList;
import seerGame.mementopackage.ScoreOriginator;
import singletonlazyinitialization.SEERManor;

import java.util.Random;

/**
 * @author xcl
 * @date 2023/12/30
 * @Description
 */
public class SafeDigging extends AbstractDigging{
    public SafeDigging(){
        super(3);
    }

    @Override
    protected boolean checkTicket(int ticket){
        System.out.println("正在检票......");
        if(ticket==0) {
            System.out.println("票数不足，无法参加复杂地形挖掘，请先购买票！！");
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
        System.out.println("\n 复杂地形挖掘正式开始！");
        Random random=new Random();
        int r=0;
        for(int i=0;i<5;i++) {
            try {
                System.out.println("小赛尔["+ SEERManor.getPlayer().getSEERName()+"]来到第"+(i+1)+"矿洞......");
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r= random.nextInt(6);
            if(r<(i+1)) {
                System.out.println("小赛尔["+SEERManor.getPlayer().getSEERName()+"]成功采集完毕第" + (i + 1) + "矿洞!!");
                Score++;
                score(Score);
            }else{
                System.out.println("小赛尔["+SEERManor.getPlayer().getSEERName()+"]在第" + (i + 1) + "关受伤了，请及时返回飞船进行治疗！！");
                break;
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected int getScore(int Score) {
        if(Score == 7){

            System.out.println("\n"+"小赛尔["+SEERManor.getPlayer().getSEERName()+"]成功完成复杂地形采集！！");
            System.out.println("小赛尔["+SEERManor.getPlayer().getSEERName()+"]的最终采集的个数为：" + Score + "（最多完成5次采集）");
            System.out.println("感谢您的贡献，小赛尔！！");

            /**
             * 添加备忘录
             */
            ScoreOriginator scoreOriginator = new ScoreOriginator();
            scoreOriginator.setRecord(Score * 2,"复杂地形采集");
            RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());

            return Score * 2;
        } else{
            System.out.println("\n"+"小赛尔["+SEERManor.getPlayer().getSEERName()+"]遗憾止步第"+ (Score + 1) + "轮!!");
            System.out.println("最终采集的个数为："+Score+"（最多完成5次采集）");
            System.out.println("感谢您的贡献！！");

            /**
             * 添加备忘录
             */
            ScoreOriginator scoreOriginator = new ScoreOriginator();
            scoreOriginator.setRecord(Score,"复杂地形采集");
            RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());

            return Score;
        }
    }

}
