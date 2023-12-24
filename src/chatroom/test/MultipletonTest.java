package chatroom.test;

import chatroom.robotpackage.Robot;

import java.util.NoSuchElementException;

public class MultipletonTest {
    /**
     * @test
     */
    public static void test(){
        System.out.println("----调用多例模式ing----");

        String npc1 = "我是" + Robot.getInstance("赛小息").getRobotName();
        String npc2 = "我是" + Robot.getInstance("阿铁打").getRobotName();
        String npc3 = "我是" + Robot.getInstance("卡璐璐").getRobotName();
        System.out.println(npc1 + "\n" + npc2 + "\n" + npc3);

        try {
            Robot r = Robot.getInstance("小赛尔");
        } catch (NoSuchElementException e) {
            System.out.println("Exception thrown  :" + e);
        }
    }

    public static void main(String[] args) {

        MultipletonTest.test();
    }
}
