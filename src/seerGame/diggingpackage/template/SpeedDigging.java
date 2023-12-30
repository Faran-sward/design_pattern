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
public class SpeedDigging extends AbstractDigging{
    public SpeedDigging(){
        super(1);
    }

    @Override
    protected boolean checkTicket(int ticket){
        System.out.println("正在检查......");
        if(ticket==0) {
            System.out.println("下矿机会不足，无法进入泰坦矿洞！！");
            return false;
        }
        else{
            ticket--;
            System.out.println("成功！\n目前剩余机会为：" + ticket);
            return true;
        }
    }

    @Override
    protected void diggingProcess(int Score) {
        System.out.println("\n最速挑战正式开始！");
        Random random=new Random();
        int r=0, is = 0;
        for(int i=0;i<5;i++) {
            r= random.nextInt(10)+10;
            is = random.nextInt(4);
            try {
                System.out.println("小赛尔["+ SEERManor.getPlayer().getSEERName()+"]正在进行第"+(i+1)+"轮采集......");
                Thread.sleep(200*(r));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(is == 0) {
                System.out.println("小赛尔[" + SEERManor.getPlayer().getSEERName() + "]完成第" + (i + 1) + "轮，" + "用时" + r * 6 + "秒!!");
                Score += (50 - r - i * 10) * 6;
                break;
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            score(Score);
        }
    }
    @Override
    protected int getScore(int Score) {
        if(Score > 10){

            System.out.println("\n"+"小赛尔["+SEERManor.getPlayer().getSEERName()+"]在规定的时间内成功完成比赛！！");
            System.out.println("小赛尔["+SEERManor.getPlayer().getSEERName()+"]的最终的成绩为：" + Score + "分");
            System.out.println("感谢您的贡献，小赛尔！！");

            /**
             * 添加备忘录
             */
            ScoreOriginator scoreOriginator = new ScoreOriginator();
            scoreOriginator.setRecord(Score,"最速挑战");
            RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());

            return Score;
        } else{
            System.out.println("\n"+"小赛尔["+SEERManor.getPlayer().getSEERName()+"]在规定的时间内未完成比赛！！");
            System.out.println("成绩无效，再接再厉！！");

            /**
             * 添加备忘录
             */
            ScoreOriginator scoreOriginator = new ScoreOriginator();
            scoreOriginator.setRecord(0,"最速挑战");
            RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());

            return 0;
        }
    }
}
