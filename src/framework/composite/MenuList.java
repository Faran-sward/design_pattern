package framework.composite;

// 外部调用者:SEERManer

public class MenuList {
    /**
     * 单例模式：菜单表
     */
    private static MenuList instance = new MenuList();

    public static MenuList getInstance() {
        return instance;
    }

    private final Menu meanMenu = new Menu("太空站枢纽");

    /**
     * 设置菜单
     */
    private MenuList() {

        /**
         * 大厅菜单
         */
        Menu amuseMenu = new Menu("有趣の游乐园");
        Menu SpaceGreenhouseMenu = new Menu("空间培育站");
        Menu shopMenu = new Menu("太空站商场");
        Menu chatMenu = new Menu("聊天室");
        meanMenu.add(amuseMenu, SpaceGreenhouseMenu, shopMenu, chatMenu, new MenuOption("查看公告"),new MenuOption("查看基本信息"));
        /**
         * 聊天室菜单
         */
        chatMenu.add(new MenuOption("发送信息"), new MenuOption("显示聊天内容"));

        /**
         * 游乐园菜单
         */
        Menu raceMenu = new Menu("赛车场");
        amuseMenu.add(new MenuOption("厨神争霸"), raceMenu, new MenuOption("棋高一招"), new MenuOption("行程信息"),new MenuOption("购买门票"));
        raceMenu.add(new MenuOption("鬼火竞速赛"), new MenuOption("机车漂移赛"), new MenuOption("空间站障碍赛"));

        /**
         * 农场菜单
         */

        /**
         * 商场菜单
         */
    }

    /**
     * 获取主菜单
     */
    public Component meanMenu() {
        return meanMenu;
    }
}
