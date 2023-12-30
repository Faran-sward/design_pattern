package seerGame.diggingpackage.template;

import exceptionhandle.ExceptionHandle;
import framework.simplefactory.SEER;
import singletonlazyinitialization.SEERManor;

import java.util.Scanner;

/**
 * @author raoji
 * @date 2023/12/30
 * @Description
 */
public abstract class AbstractDigging{

    private SEER seer = SEERManor.getPlayer();
    private int ticket;  // chances to dig
    private int score;  // what seer obtained
    private int type;

    public AbstractDigging(int type) {
        this.type = type;
        this.ticket = seer.getTicket();
        this.score = 0;
    }

    public void score(int score){this.score = score;}


    /**
     * 检票
     */
    protected abstract boolean checkTicket(int ticket);


    /**
     * 准备阶段
     */
    public void Prepare(){
        ExceptionHandle exceptionHandle=new ExceptionHandle();
        System.out.println("\n请赛尔系好检查装备，戴好头盔，游戏马上开始！！");
        System.out.println("输入1：确保检查矿镐没有问题");
        Scanner input=new Scanner(System.in);
        int s=0;
        s=exceptionHandle.exception();
        while(s!=1){
            System.out.println("未携带矿镐，请重新输入");
            s=exceptionHandle.exception();
        }
        System.out.println("输入2：确保头盔戴好");
        s=exceptionHandle.exception();
        while(s!=2){
            System.out.println("还未戴好头盔，请重新输入");
            s=exceptionHandle.exception();
        }
        System.out.println("输入3：确认游戏开始");
        s=exceptionHandle.exception();
        while(s!=3){
            System.out.println("输入3：确认进入泰坦矿洞");
            s=exceptionHandle.exception();
        }
    }

    /**
     * 不同赛车不同过程
     */
    protected abstract void diggingProcess(int score);

    /**
     * 获取得分
     */
    protected abstract int getScore(int score);

    /**
     * 整个过程模板
     */
    public void StartDigging(){

        if(checkTicket(ticket)==false) {
            System.out.println("\n正在返回塞尔飞船...\n");
            return;
        }


        seer.setTicket(--ticket);

        Prepare();

        diggingProcess(score);

        score = getScore(score);
        seer.setScore(seer.getScore() + score);
        System.out.println("小赛尔[" + SEERManor.getPlayer().getSEERName() + "]此次获得矿石数：" + score + ", 总积分为：" + seer.getScore());

        System.out.println("正在返回赛尔飞船..\n");
    }


    /**
     * @test
     */
    public void test(){
        score = getScore(score);
    }


}