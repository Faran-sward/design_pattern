package framework.interpreter;

import framework.interpreter.calculate.Expression;
import framework.interpreter.calculate.Mul;
import framework.interpreter.calculate.Number;
import framework.interpreter.calculate.Sub;
import framework.simplefactory.SEER;
import singletonlazyinitialization.SEERManor;

import java.util.Scanner;

// 外部调用者:SEERamuse

public class BuyTicket {
    private final double fare=100;
    private double money;
    private int ticket;

    public BuyTicket(SEER seer){
        this.money=seer.getMoney();
        this.ticket=seer.getTicket();
    }

    public void buyTicket(){
        System.out.println("票的价格为"+fare+"赛尔豆，"+"现有"+money+"赛尔豆");
        System.out.print("请选择买票的张数：");

        Scanner input=new Scanner(System.in);
        int num = input.nextInt();
        changeTicket(num);
    }

    public void changeTicket(int num){

        Expression Efare=new Number(fare);
        Expression Enum=new Number(num);
        Expression Emoney=new Number(money);

        Expression Eresult=new Sub(Emoney,new Mul(Enum,Efare));

        double result=Eresult.interpret();

        if(result>=0){
            ticket+=num;
            money=result;
            SEERManor.getPlayer().setMoney(money);
            SEERManor.getPlayer().setTicket(ticket);
            System.out.println("购买门票成功，现有门票"+ticket+"张，"+money+"赛尔豆\n");
        }
        else{
            System.out.println("购买门票失败，现有门票"+ticket+"张，"+money+"赛尔豆\n");
        }
    }
}
