package singletonlazyinitialization;

import backpack.MVC.BackpackController;
import backpack.MVC.BackpackView;
import backpack.information.PutInformation;
import chatroom.ChatUI;
import chatroom.robotpackage.NPCList;
import framework.blackboard.BlackboardUI;
import framework.composite.Component;
import framework.composite.MenuList;
import framework.simplefactory.SEER;
import framework.simplefactory.SEERCreator;
import framework.simplefactory.SEERFactory;

import java.util.Scanner;


public class SEERManor {
    //创建一个SEERManor的一个静态对象
    private static SEER player;

    //菜单
    private static Component currentMenu;

    /**
     * 天气情况
     */
    String[] weathers={"晴天","雨天","阴天"};
    String weather=weathers[(int)(Math.random()*3)];

    //构造函数为private，该类不会被实例化
    private SEERManor(){
    }

    public static SEERManor getInstance(){return SingletonHolder.getInstance();}
    //输出测试信息
    public void showMessage(){
        System.out.println("SEERManor is created successfully!");
    }

    /**
     * 测试用例！！！！
     * @test
     */
    public void test() {
        SEERFactory seerFactory = new SEERFactory();
        player = seerFactory.createSEER("罗杰船长","Red");
        player.setSEERName("test");
        player.setMoney(2000);
        player.setTicket(2);
        player.setScore(0);
    }



    public void flowController() throws CloneNotSupportedException{
        System.out.println("欢迎来到赛尔号！\n\n\n");
        Scanner input = new Scanner(System.in);

        /**
         * 创建角色
         */
        player = SEERCreator.getInstance().createSEER();
        System.out.println("\n角色创建成功，正在进入赛尔号大厅！！！\n\n\n");

        /**
         * 添加NPC
         */
        NPCList.getInstance().start();

        /**
         * 主菜单
         */
        currentMenu = MenuList.getInstance().meanMenu();

        /**
         * 公告
         */
        BlackboardUI blackboard = new BlackboardUI();
        blackboard.showBlackboard();

        /**
         * 背包信息
         */
        BackpackView backpackView = new BackpackView();
        BackpackController controller = new BackpackController(player.getBackpack(), backpackView);
        PutInformation putInformation = new PutInformation();


        while(true){

            printMenu();

            int i = input.nextInt();

            moveTo(i - 1);

            switch(i){
                case 1:
                    System.out.println("\n正在进入有趣の游乐园！");
                    //GameUI gamemaker = new GameUI();
                    //gamemaker.playGame();
                    break;
                case 2:
                    System.out.println("欢迎来到空间培育站！\n");
                    //SpaceGreenhouseProcess SpaceGreenhouseProcess = SpaceGreenhouseProcess.newInstance();
                    //SpaceGreenhouseProcess.process();
                    break;
                case 3:
                    System.out.println("欢迎来到太空站商场！\n");
                    //MallProcess mallProcess=MallProcess.newInstance();
                    //mallProcess.process();
                    break;
                case 4:
                    System.out.println("\n正在进入聊天室！");
                    ChatUI chatroom = new ChatUI();
                    chatroom.chatting();
                    break;
                case 5:
                    System.out.println("\n正在显示广告牌内容！");
                    blackboard.showBlackboard();
                    break;
                case 6:
                    System.out.println("\n正在显示赛尔的基本信息！");
                    putInformation.showSEERInformation(player,controller);;
                    break;
                case 0:
                    goback();
                    System.out.println("\n您即将离开赛尔号，再见是为了更好的重逢！");
                    //终止NPC线程
                    NPCList.getInstance().stop();
                    return;
                default:
                    break;
            }

            goback();

        }
    }

    public static SEER getPlayer() {
        return player;
    }


    /**
     * 延迟初始化
     * 需要才创建，保证线程安全
     */
    private static class SingletonHolder{
        private static SEERManor instance = new SEERManor();
        public static SEERManor getInstance() {
            return instance;
        }
    }

    /**
     * 菜单切换，打印操作
     * @param index
     */
    public static void moveTo(int index){
        currentMenu = currentMenu.moveTo(index);
    }

    public static void goback(){
        currentMenu = currentMenu.getLast();
    }

    public static void printMenu(){
        currentMenu.printMenu();
    }

}
