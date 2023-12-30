package seerGame;


import exceptionhandle.ExceptionHandle;
import framework.interpreter.BuyTicket;
import seerGame.mementopackage.RecordList;
import singletonlazyinitialization.SEERManor;

import java.util.Scanner;

public class GameUI {

    private GameMaker gameMaker = GameMaker.getInstance();
    BuyTicket by;


    public GameUI(){
    }

    public void playGame(){

        while(true){

            SEERManor.printMenu();

            Scanner scan = new Scanner(System.in);
            ExceptionHandle exceptionHandle = new ExceptionHandle();
            int i = exceptionHandle.exception();

            SEERManor.moveTo(i - 1);

            switch(i){
                case 1:
                    gameMaker.playShopping();
                    break;
                case 2:
                    System.out.println("\n正在进入挖掘区！");
                    gameMaker.playDigging();
                    break;
                case 3:
                    RecordList.getInstance().printList();
                    break;
                case 4:
                    by = new BuyTicket(SEERManor.getPlayer());
                    by.buyTicket();
                    break;
                case 0:
                    SEERManor.goback();
                    System.out.println("\n 已离开活动区，即将返回赛尔飞船！！！\n\n\n");
                    return;
                default:
                    break;
            }

            SEERManor.goback();

        }
    }
}