package seerGame.diggingpackage;

import exceptionhandle.ExceptionHandle;
import seerGame.Game;
import seerGame.diggingpackage.template.AbstractDigging;
import seerGame.diggingpackage.template.DepthDiggging;
import seerGame.diggingpackage.template.SafeDigging;
import seerGame.diggingpackage.template.SpeedDigging;
import singletonlazyinitialization.SEERManor;

/**
 * @author xcl
 * @date 2023/12/30
 * @Description
 */
public class Digging implements Game {
    @Override
    public void Play() {

        AbstractDigging abstractRacing = null;
        int racingType = 0;

        //用于异常处理
        ExceptionHandle exceptionHandle = new ExceptionHandle();

        while (racingType == 0) {

            SEERManor.printMenu();

            racingType=exceptionHandle.exception();

            switch (racingType) {
                case 1:
                    System.out.println("\n正在准备限时开采！");
                    abstractRacing = new SpeedDigging();
                    abstractRacing.StartDigging();
                    racingType = 0;
                    break;
                case 2:
                    System.out.println("\n正在准备下潜挖矿赛！");
                    abstractRacing = new DepthDiggging();
                    abstractRacing.StartDigging();
                    racingType = 0;
                    break;
                case 3:
                    System.out.println("\n正在准备复杂地形开采！");
                    abstractRacing = new SafeDigging();
                    abstractRacing.StartDigging();
                    racingType = 0;
                    break;
                case 0:
                    System.out.println("\n" + "正在退出挖掘区......\n成功离开，已返回赛尔飞船！\n");
                    return;
                default:
                    racingType = 0;
                    break;
            }
        }
    }
}
