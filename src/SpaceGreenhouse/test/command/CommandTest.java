package SpaceGreenhouse.test.command;

import framework.simplefactory.SEER;
import SpaceGreenhouse.common.SpaceGreenhouseWarehouse;
import SpaceGreenhouse.pattern.command.Command;
import SpaceGreenhouse.pattern.command.conc.FertilizerCommand;
import SpaceGreenhouse.pattern.command.conc.SeedCommand;

public class CommandTest {
    public static void test(){
        Command fertilizerCommand = new FertilizerCommand();
        Command seedCommand = new SeedCommand();
        System.out.println("----调用命令模式ing----");
        SpaceGreenhouseWarehouse warehouse = SpaceGreenhouseWarehouse.getInstance(new SEER());
        ((FertilizerCommand) fertilizerCommand).setSpaceGreenhouseWarehouse(warehouse);
        System.out.println("正在向商店购买1份高级肥料");
        boolean result = fertilizerCommand.execute("高级肥料", 1);
        System.out.println(result==false?"抱歉，赛尔豆余额不足，购买失败":"恭喜，购买成功！");
        //seedCommand.execute("小麦种子",-1);
    }
    public static void main(String[] args) {
        test();
    }
}
