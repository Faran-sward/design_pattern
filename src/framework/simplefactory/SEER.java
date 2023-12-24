package framework.simplefactory;

import backpack.MVC.Backpack;
import framework.simplefactory.color.Color;
import framework.simplefactory.role.Role;

// 外部调用者:SEERfarm
//赛尔的角色相关信息
public class SEER {
    private String SEERName;      //名字
    private Role SEERRole;      //角色
    private Color SEERColor;      //颜色
    private double money;      //摩尔豆
    private int ticket;      //游乐园票数
    private int score;      //游戏积分
    private Backpack backpack;//背包

    public SEER(){
    }

    //set和get函数
    public void setSEERName(String seerName){
        SEERName=seerName;
    };
    public String getSEERName(){return SEERName;}

    public void setSEERColor(Color seerColor) {
         SEERColor=seerColor;
    }
    public Color getSEERColor(){return SEERColor;}

    public void setSEERRole(Role seerRole){
        SEERRole=seerRole;
    }
    public Role getSEERRole(){return SEERRole;}

    public void setMoney(double money){
        this.money=money;
    }
    public double getMoney(){return money;}

    public void setTicket(int ticket){
        this.ticket=ticket;
    }
    public int getTicket(){return ticket;}

    public void setScore(int score){this.score=score;}
    public int getScore(){return score;}

    public void setBackpack(Backpack backpack){this.backpack=backpack;}
    public Backpack getBackpack(){return backpack;}

}
