package chatroom.robotpackage;

import chatroom.Chatroom;

import java.util.*;

/**
 * NPC
 */
public enum Robot implements Runnable {

    /**
     * 使用枚举类型实现多例模式
     */
    SaiXiaoxi("赛小息"),ATieda("阿铁打"),KaLulu("卡璐璐"),DiEn("迪恩");

    /**
     * 获取一个NPC的单例
     * @param robotName
     * @return
     */
    public static Robot getInstance(String robotName){
        return switch (robotName){
            case "赛小息" -> SaiXiaoxi;
            case "阿铁打" -> ATieda;
            case "卡璐璐" -> KaLulu;
            case "迪恩" -> DiEn;
            default->throw new NoSuchElementException("找不到该NPC!");
        };
    }

    //终止线程标识符
    public volatile boolean exit = false;

    private Thread t;

    //NPC名字
    private String RobotName;

    private String[] randMessage = {"",
            "嗨，冒险家！听说最近有个怪物在森林深处出没。我想去调查一下。",
            "我已经找到了古老遗迹的线索，但它被一道力量封印了。我们需要解开这个谜题！",
            "我想去太空站商场！",
            "和伙伴一起在赛尔号享受美好时光吧",
            "新来的朋友，你好呀！",
            "欢迎来到赛尔联盟总部！",
            "和朋友们聊天真开心！"};

    private Random random = new Random();


    /**
     * 私有构造函数
     * @param name
     */
    Robot(String name) {
        RobotName = name;
        randMessage[0] = "我是" + name;
    }

    private String BuildMessage(){
        int r = random.nextInt(4);
        return randMessage[r];
    }

    private void sendMessage(String message){
        Chatroom.getInstance().addMessage(RobotName, message);
    }

    public String getRobotName() {
        return RobotName;
    }

    /**
     * NPC操作：向聊天室添加消息
     */
    public void run() {

        try {
            while (exit) {

                String str = BuildMessage();

                //获取线程锁
                Chatroom.getInstance().Lock();
                //发送信息
                try {
                    sendMessage(str);
                } finally {
                    Chatroom.getInstance().unLock();//解锁
                }

                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  RobotName + " interrupted.");
        }


    }


    /**
     * 启动NPC
     */
    public void start () {

        if (t == null) {
            t = new Thread (this, RobotName);
            t.start ();
            exit = true;
        }

    }

    public void stop() {exit = false;}
}
