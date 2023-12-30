package framework.simplefactory;

import backpack.MVC.Backpack;
import exceptionhandle.ExceptionHandle;

import java.util.Scanner;
// seermaner
public class SEERCreator {

    private SEERCreator() {}
    private static SEERCreator instance = new SEERCreator();
    public static SEERCreator getInstance(){
        return instance;
    }

    /**
     * 创建角色
     * @return
     */
    public SEER createSEER(){
        Scanner input = new Scanner(System.in);
        //用于异常处理

        ExceptionHandle exceptionHandle=new ExceptionHandle();

        int roleNum=0, colorNum=0;

        System.out.println("请输入你的昵称：");
        String name = input.nextLine();

        String role = "发明家肖恩";
        String color = "Red";

        while(roleNum==0){
            System.out.println("选择你的角色：[1]发明家肖恩 [2]派特博士 [3]机械师爱丽丝 [4]雷蒙教官");
            roleNum=exceptionHandle.exception();
            switch(roleNum){
                case 1:
                    role="发明家肖恩";
                    break;
                case 2:
                    role="派特博士";
                    break;
                case 3:
                    role="机械师爱丽丝";
                    break;
                case 4:
                    role="雷蒙教官";
                    break;
                default:
                    roleNum=0;
                    break;
            }
        }

        while(colorNum==0){
            System.out.println("选择外观颜色：[1]玫瑰红 [2]帅气绿 [3]深海蓝 [4]温柔粉");
            colorNum = exceptionHandle.exception();
            switch(colorNum){
                case 1:
                    color="Red";
                    break;
                case 2:
                    color="Green";
                    break;
                case 3:
                    color="Blue";
                    break;
                case 4:
                    color="Pink";
                    break;
                default:
                    colorNum=0;
                    break;
            }
        }

        SEERFactory seerFactory = new SEERFactory();
        SEER seer = seerFactory.createSEER(role,color);
        Backpack backpack=new Backpack();

        seer.setSEERName(name);
        seer.setMoney(2000);
        seer.setTicket(2);
        seer.setScore(0);
        seer.setBackpack(backpack);

        return seer;
    }


}
