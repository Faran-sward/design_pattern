package backpack.information;

import backpack.MVC.BackpackController;
import framework.simplefactory.SEER;
public class PutInformation {
    public void showMoleInformation(SEER seer,BackpackController controller){
        System.out.println("\n赛尔基础属性：");
        System.out.println("赛尔昵称："+seer.getSEERName());
        System.out.println("当前角色："+seer.getSEERRole().getRole());
        System.out.println("赛尔颜色："+seer.getSEERColor().getColor());
        System.out.println("赛尔豆："+seer.getMoney());
        System.out.println("游戏积分："+seer.getScore());
        System.out.printf("%-15s\t%s\n","背包物品" ,"数量");
        System.out.printf("%-15s\t%d\n","游乐园门票" ,seer.getTicket());
        controller.updateView();
        System.out.print("\n\n\n");
    }
}
