package chatroom.robotpackage;

import java.util.ArrayList;

public class NPCList {

    private ArrayList<Robot> NpcList = new ArrayList<>();

    /**
     * 构造函数
     * 获取NPC的实例并添加到NPC列表中
     */
    private NPCList() {
        Robot SaiXiaoxi = Robot.getInstance("赛小息");
        Robot ATieda = Robot.getInstance("阿铁打");
        Robot KaLulu = Robot.getInstance("卡璐璐");
        Robot DiEn = Robot.getInstance("迪恩");

        NpcList.add(SaiXiaoxi);
        NpcList.add(ATieda);
        NpcList.add(KaLulu);
        NpcList.add(DiEn);
    }
    private static NPCList instance = new NPCList();
    public static NPCList getInstance(){
        return instance;
    }


    /**
     * 启动NPC
     */
    public void start(){
        for(Robot r : NpcList){
            r.start();
        }
    }

    /**
     * 停用NPC
     */
    public void stop(){
        for(Robot r : NpcList){
            r.stop();
        }
    }
}
