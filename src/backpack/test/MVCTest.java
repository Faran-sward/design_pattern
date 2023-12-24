package backpack.test;
import backpack.MVC.*;
public class MVCTest {
    public static void test()
    {
        Backpack model= retrieveStudentFromDatabase();
        BackpackView view=new BackpackView();
        BackpackController controller=new BackpackController(model,view);
        System.out.println("----使用MVC模式ing----");
        System.out.println("背包物品\t\t\t数量");
        controller.updateView();
        System.out.println();
        System.out.println("加入一件粒子束护罩");
        controller.AddBackpackItem("粒子束护罩",1,"clothes");
        System.out.println("背包物品\t\t\t数量");
        controller.updateView();
        System.out.println("\n删除所有粒子束护罩");
        controller.DelBackpackItem("粒子束护罩","clothes");
        System.out.println("背包物品\t\t\t数量");
        controller.updateView();
    }
    public static void main(String[] args) {
        test();
    }

    private static Backpack retrieveStudentFromDatabase(){
        Backpack backpack=new Backpack();
        backpack.test();
        backpack.AddClothes("电力护盾",1);
        backpack.AddFood("电池能量块",2);
        return backpack;
    }
}
