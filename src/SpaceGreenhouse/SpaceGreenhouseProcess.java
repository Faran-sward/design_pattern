package SpaceGreenhouse;

import SpaceGreenhouse.common.*;
import SpaceGreenhouse.common.exception.product.ProductNotFoundException;
import SpaceGreenhouse.common.exception.product.conc.CropsNotFoundException;
import SpaceGreenhouse.common.exception.product.conc.FertilizerNotFoundException;
import SpaceGreenhouse.common.exception.product.conc.SeedNotFoundException;
import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.common.product.IProduct;
import SpaceGreenhouse.pattern.adapter.conc.WeatherAdapter;
import SpaceGreenhouse.pattern.adapter.conc.SeerAdapter;
import SpaceGreenhouse.pattern.builder.Director;
import SpaceGreenhouse.pattern.builder.conc.ConcreteBuilder1;
import SpaceGreenhouse.pattern.builder.conc.ConcreteBuilder2;
import SpaceGreenhouse.pattern.factory.Factory;
import SpaceGreenhouse.pattern.factory.conc.CropsFactory;
import SpaceGreenhouse.pattern.factory.conc.FertilizerFactory;
import SpaceGreenhouse.pattern.factory.conc.SeedFactory;
import SpaceGreenhouse.pattern.iterator.conc.SpaceGreenhouseIterator;
import SpaceGreenhouse.pattern.observer.WeatherObserver;
import SpaceGreenhouse.pattern.proxy.Proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 农场主进程
 */
public class SpaceGreenhouseProcess {
    //赛尔角色
    private SeerAdapter SEER=SeerAdapter.getInstance();
    //太空温室
    private SpaceGreenhouse SpaceGreenhouse = SEER.getSpaceGreenhouse();
    //仓库
    private SpaceGreenhouseWarehouse warehouse = SEER.getSpaceGreenhouseWarehouse();
    //商店
    private Shop shop = Home.shop;
    //具体工厂，负责生产种子/作物/肥料
    private final SeedFactory seedFactory = Home.seedFactory;

    private final CropsFactory cropFactory = Home.cropsFactory;

    private final FertilizerFactory fertilizerFactory = Home.fertilizerFactory;
    //天气适配器
    private WeatherAdapter weatherAdapter=WeatherAdapter.getInstance();

    //代理模式
    private Proxy proxy = new Proxy();

    private SpaceGreenhouseProcess() {}

    private static volatile SpaceGreenhouseProcess SpaceGreenhouseProcess = new SpaceGreenhouseProcess();

    public static synchronized SpaceGreenhouseProcess newInstance() {
        return SpaceGreenhouseProcess;
    }

    /**
     * 农场进程
     * @param str3
     * @param block
     */
    public void SpaceGreenhouseSmallProcess(String str3, SpaceGreenhouseBlock block) {
        Scanner input = new Scanner(System.in);
        switch (str3) {
            case "1":
                if (block.getSeed() == null) {
                    System.out.println("请输入想要种植的作物种子：(白菜/茄子/水稻/草莓/西瓜/小麦种子)");
                    String seedName = input.next();
                    System.out.println("请选择种植方式：[1]普通种植 [2]一键种植(种植+初级肥料) [3]超级一键种植(松土+种植+浇水+除草+高级肥料)");
                    String way = input.next();
                    try {
                        switch (way) {
                            case "1":
                                SpaceGreenhouseGrowth.plantSeed(seedName, block);
                                break;
                            case "2":
                                //调用建造者模式
                                ConcreteBuilder2 concreteBuilder2 = new ConcreteBuilder2();
                                concreteBuilder2.setSpaceGreenhouseBlock(block);
                                Director director = new Director(concreteBuilder2, block);
                                director.getSpaceGreenhouseBlock(seedFactory.create(Home.seedMap.get(seedName)));
                                break;
                            case "3":
                                ConcreteBuilder1 concreteBuilder1 = new ConcreteBuilder1();
                                concreteBuilder1.setSpaceGreenhouseBlock(block);
                                Director director1 = new Director(concreteBuilder1, block);
                                director1.getSpaceGreenhouseBlock(seedFactory.create(Home.seedMap.get(seedName)));
                                break;
                            default:
                                break;
                        }
                    } catch (SeedNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("该土地上已有种子，无法继续种植");
                }
                break;
            case "2":
                //收获
                SpaceGreenhouseGrowth.harvestCrops(block);
                break;
            case "3":
                //浇水
                SpaceGreenhouseGrowth.watering(block);
                break;
            case "4":
                //除草
                SpaceGreenhouseGrowth.weed(block);
                break;
            case "5":
                //除虫
                SpaceGreenhouseGrowth.disinsection(block);
                break;
            case "6":
                //施肥
                if (block.getSeed() == null) {
                    System.out.println("该土地没有种植作物，播种后再施肥效果更佳噢");
                } else if (block.getSeedStatus() == 6 || block.getSeedStatus() == 7) {
                    System.out.println("作物已经成熟，请立即收获");
                } else {
                    try {
                        System.out.println("请选择肥料：高级肥料(库存：" + warehouse.getFertilizerMap().get(fertilizerFactory.create(
                                "AdvancedFertilizer")) + ")，中级肥料(库存：" + warehouse.getFertilizerMap().get(fertilizerFactory.create(
                                "MiddleFertilizer")) + ")，初级肥料(库存：" + warehouse.getFertilizerMap().get(fertilizerFactory.create(
                                "PrimaryFertilizer")) + ")");
                        String fertilizerName = input.next();
                        SpaceGreenhouseGrowth.applyFertilizer(fertilizerName, block);
                    } catch (FertilizerNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            case "7":
                //铲除作物
                SpaceGreenhouseGrowth.eradicateCrops(block);
                break;
            default:
        }
    }

    /**
     * 太空温室进程
     *
     * @param str2
     */
    public void SpaceGreenhouseProcess(String str2) {
        Scanner input = new Scanner(System.in);
        while (true) {
            //批量操作
            if ("b".equals(str2)) {
                System.out.println("\n批量操作");
                System.out.println("请选择操作：[0]返回上级 [1]选择批量播种 [2]选择批量收获 ：");
                String str3 = input.next();
                if ("1".equals(str3)) {
                    System.out.println("请输入想要种植的作物种子：(白菜/茄子/水稻/草莓/西瓜/小麦种子)");
                    String name = input.next();
                    try {
                        SpaceGreenhouse.plantBatchSeeds(name);
                    } catch (SeedNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                } else if ("2".equals(str3)) {
                    //批量收获作物并放入仓库
                    if (warehouse.storeToRepository(SpaceGreenhouse.harvestBatchSeeds())) {
                        System.out.println("已为您批量收获作物并放入仓库");
                    }
                } else if ("0".equals(str3)) {
                    break;
                }
            }
            //单个太空温室块操作
            else {
                //获取太空温室块编号
                int index = Integer.parseInt(str2) - 1;
                //获取具体太空温室块对象
                SpaceGreenhouseIterator iterator = SpaceGreenhouse.getIterator();
                SpaceGreenhouseBlock block = iterator.getByIndex(index);
                //控制台输出太空温室块信息
                block.getInfo();
                System.out.println("请选择：[0]返回上级 [1]种植作物 [2]收获作物 [3]浇水 [4]除草 [5]除虫 [6]施肥 [7]铲除作物");
                String str3 = input.next();
                if ("0".equals(str3)) {
                    break;
                }
                //对作物进行具体操作
                SpaceGreenhouseSmallProcess(str3, block);
            }
        }
    }

    /**
     * 仓库进程
     * @param objName
     * @param name
     * @param factory
     * @param <T>
     */
    private <T extends Factory> void warehouseSmallProcess(String objName, String name, T factory) {
        try {
            Scanner input = new Scanner(System.in);
            String objClassName;
            if(Home.seedMap.get(objName)==null) {
                objClassName = Home.fertilizerMap.get(objName);
            }
            else {
                objClassName=Home.seedMap.get(objName);
            }
            IProduct obj = factory.create(objClassName);
            System.out.println("请输入想要购买的" + name + "数目(您现在有" + SEER.getSeerDou() + "赛尔豆):");
            int objNum;
            String str = input.next();
            if (str.matches("[0-9]+")) {
                objNum = Integer.parseInt(str);
            } else {
                System.out.println("请输入正确的数字哦\n");
                return;
            }
            Double price = objNum * obj.getPrice();
            if (obj instanceof AbstractSeed) {
                //if (shop.buySeeds((AbstractSeed) obj, objNum)) {
                if (proxy.seedPurchase(objName, objNum)) {
                    System.out.println("正在向商店购买" + obj.getName() +
                            "，共消费" + price + "赛尔豆，" +
                            "剩余" + SEER.getSeerDou() + "赛尔豆\n");
                } else {
                    System.out.println("购买失败！");
                }
            } else {
                if (proxy.fertilizerPurchase(objName, objNum)) {
                    System.out.println("正在向商店购买" + obj.getName() +
                            "，共消费" + price + "赛尔豆，" +
                            "剩余" + SEER.getSeerDou() + "赛尔豆\n");
                } else {
                    System.out.println("购买失败！");
                }
            }
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 仓库进程
     *
     * @param str4
     */
    public void warehouseProcess(String str4) {
        Scanner input = new Scanner(System.in);
        while (true) {
            switch (str4) {
                case "1":
                    String text1 = "种子";
                    System.out.println("请输入想要购买的" + text1 + "类型" +
                            "(白菜种子--6.0，茄子种子--10.0，水稻种子--4.0，草莓种子--12.0，西瓜种子--10.0，小麦种子--6.0)，" +
                            "输入0返回上级：");
                    String objName = input.next();
                    if ("0".equals(objName)) {
                        return;
                    }
                    //挑选种类，输入数目，买入种子
                    warehouseSmallProcess(objName, text1, seedFactory);
                    break;
                case "2":
                    String text2 = "肥料";
                    System.out.println("请输入想要购买的" + text2 + "类型" +
                            "(高级肥料--10.0，中级肥料--5.0，初级肥料--2.0)，" +
                            "输入0返回上级：");
                    String objName1 = input.next();
                    if ("0".equals(objName1)) {
                        return;
                    }
                    warehouseSmallProcess(objName1, text2, fertilizerFactory);
                    break;
                case "3":
                    //挑选种类，输入数目，卖出作物
                    System.out.println("请输入想要卖出的作物类型" +
                            "(白菜--5.0，茄子--10.0，水稻--2.0，草莓--15.0，西瓜--10.0，小麦--2.0)"
                            + "，输入0返回上级：");
                    String cropName = input.next();
                    if (cropName.equals("0")) {
                        return;
                    }
                    String cropClassName =Home.cropsMap.get(cropName);
                    System.out.println("请输入想要卖出的作物数目：");
                    String next = input.next();
                    int cropNum;
                    if(next.matches("[0-9]+")){
                        cropNum=Integer.parseInt(next);
                    }else{
                        System.out.println("请输入正确的数字哦\n");
                        return;
                    }
                    try {
                        warehouse.sellCrops(cropFactory.create(cropClassName), cropNum);
                    } catch (CropsNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    return;
            }
        }
    }

    /**
     * 农场主函数
     */
    public void process() {
        Scanner input = new Scanner(System.in);
        //观察者模式,通过修改天气，修改除草和浇水的方法
        WeatherAdapter.adapter=WeatherAdapter.changeWeather();
        weatherAdapter=WeatherAdapter.getInstance();
        WeatherObserver weatherObserver = WeatherObserver.getInstance();
        weatherObserver.observer(weatherAdapter);
        while (true) {
            //欢迎辞
            System.out.print("\n欢迎来到欢乐农场！\n" +
                    "今日天气：");

            //获取今日天气并输出
            System.out.print(this.weatherAdapter.getWeather() + "\n");
            System.out.println("请选择您要去的地方：[1]太空温室 [2]仓库 [0]赛尔大厅");
            String str1 = input.next();
            if("0".equals(str1))break;
            for (SpaceGreenhouseIterator it = SpaceGreenhouse.getIterator(); it.hasNext(); ) {
                SpaceGreenhouseBlock next = it.next();
                if (next.getSeed() != null && next.getSeedStatus() != null) {
                    next.growth();
                }
            }
            //太空温室模块
            while ("1".equals(str1)) {
                //绘制太空温室状态图
                SpaceGreenhouse.showSpaceGreenhouse(this.weatherAdapter.getWeather());
                System.out.println("请选择操作：[0]返回农场首页 [1~9]查看具体太空温室块状态 [b]批量操作：");
                String str2 = input.next();
                List<String> con = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    con.add(String.valueOf(i));
                }
                con.add("b");
                if (con.contains(str2)) {
                    if("0".equals(str2)) {
                        break;
                    }
                    SpaceGreenhouseProcess(str2);
                }
            }
            //仓库模块
            while ("2".equals(str1)) {
                warehouse.showRepertory();
                System.out.println("请选择操作：[0]返回农场首页 [1]买入种子 [2]买入肥料 [3]卖出作物");
                String str4 = input.next();
                List<String> con=new ArrayList<>();
                for(int i=0;i<4;i++){
                    con.add(String.valueOf(i));
                }
                if(con.contains(str4)) {
                    if ("0".equals(str4)) {
                        break;
                    }
                    warehouseProcess(str4);
                }
            }
        }
    }

}
