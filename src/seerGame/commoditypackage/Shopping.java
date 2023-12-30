package seerGame.commoditypackage;



/**
 * @author raoji
 * @date 2023/12/30
 * @Description
 */

import exceptionhandle.ExceptionHandle;
import framework.simplefactory.SEER;
import seerGame.Game;
import seerGame.commoditypackage.prototype.Abstractshopping;
import seerGame.mementopackage.RecordList;
import seerGame.mementopackage.ScoreOriginator;
import singletonlazyinitialization.SEERManor;

import java.util.Scanner;

public class Shopping implements Game {

    private SEER seer = SEERManor.getPlayer();

    @Override
    public void Play() {
        System.out.println("\n进入赛尔商店!");
        Scanner input = new Scanner(System.in);

        int index = 0;

        ShoppingCache.loadCache();

        while(true){
            System.out.println("\n请输入你想制做的物品菜：[1]体力恢复药 [2]精灵胶囊 [3]技能值恢复药");

            String type = input.nextLine();

            Abstractshopping clonedmeal = (Abstractshopping) ShoppingCache.getCommodity(type);
            if (clonedmeal == null) {
                System.out.println("\n！");
            } else {
                clonedmeal.manufacture();
                index ++;
            }


            System.out.println("\n是否领取奖励，离开商店？[0]离开商店 [1]继续逛逛");

            ExceptionHandle exceptionHandle = new ExceptionHandle();
            int choice = exceptionHandle.exception();
            if(choice != 1)  break;
        }

        seer.setScore(seer.getScore() + index);
        System.out.println("\n小塞尔["+SEERManor.getPlayer().getSEERName()+"]此次获得游戏积分：" + index + ", 总积分为：" + seer.getScore());

        seer.setMoney(seer.getMoney() - 100 * index);
        System.out.println("小赛尔["+SEERManor.getPlayer().getSEERName()+"]此次扣除赛尔豆：" + 100 * index + ", 总摩尔豆为：" + seer.getMoney());

        /**
         * 添加备忘录
         */
        ScoreOriginator scoreOriginator = new ScoreOriginator();
        scoreOriginator.setRecord(index,"星际商店");
        RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());

        System.out.println("\n正在退出星际商店......\n成功退出，已返回飞船！\n");
    }
}
