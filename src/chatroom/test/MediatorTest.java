package chatroom.test;

import chatroom.Chatroom;
import framework.simplefactory.SEER;
import framework.simplefactory.SEERFactory;

public class MediatorTest {

    /**
     * @test
     */
    public static void test(){
        System.out.println("----调用观察者模式ing----");
        SEERFactory seerFactory = new SEERFactory();
        SEER seer1 = seerFactory.createSEER("赛小息", "Red");
        SEER seer2 = seerFactory.createSEER("阿铁打", "Red");
        Chatroom chatroom = Chatroom.getInstance();
        chatroom.addMessage(seer1.getSEERName(), "你好");
        chatroom.addMessage(seer2.getSEERName(), "小赛尔");
        chatroom.showMessage();
    }

    public static void main(String[] args) {
        MediatorTest.test();
    }

}
