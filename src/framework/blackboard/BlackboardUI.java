package framework.blackboard;
import java.util.Random;

// 外部调用者:SEERManer
public class BlackboardUI {
    /**
     * 显示公告内容
     */
    public void showBlackboard(){

        Blackboard blackboard = new Blackboard();
        Random random = new Random();

        // 生成随机数
        int randomNumber = random.nextInt(20000) ;

        // 气温
        // 农作物
        // 背包
        // 聊天信息
        // 商场
        // NPC
        Control control = new Control(blackboard);
        control.addNotice("你的背包好像空空的，要不去商场看看呢！");
        control.addNotice("游乐园的赛车游戏很有趣！");
        control.addNotice("试衣间又推出新品啦，快去试穿一下吧！");
        control.addNotice("咦？你口袋里有一些种子诶，快去农场看看吧！");
        control.addNotice("今天的天气晴朗，适宜户外活动，快来享受阳光吧！");
        control.addNotice("有什么趣事、心情或话题想和大家分享吗？快来聊天室与大家互动吧！");
        control.addNotice("阿铁打好像在修他的机械臂，要不去和他一起？");
        control.addNotice("卡璐璐那里有电磁能量球可以补充体力");
        control.addNotice("迪奥身上的火焰抗性外套看起来很酷！");
        control.addNotice("温馨提示：明天将有"+randomNumber+"颗小行星掠过，出门时请注意安全噢");

        control.addAllNotice();

        blackboard.show();
        System.out.println();
    }
}