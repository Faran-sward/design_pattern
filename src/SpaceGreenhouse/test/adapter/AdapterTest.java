package SpaceGreenhouse.test.adapter;

import framework.simplefactory.SEER;
import SpaceGreenhouse.common.SpaceGreenhouseBlock;
import SpaceGreenhouse.pattern.adapter.conc.SeerAdapter;
import SpaceGreenhouse.pattern.adapter.conc.WeatherAdapter;

public class AdapterTest {
    private static WeatherAdapter weatherAdapter;

    private SEER SEER = new SEER();
    //测试天气适配器
    public static void WeatherTest(){
        System.out.println("----调用适配器模式ing----");
        //随机跳转天气
        weatherAdapter = WeatherAdapter.changeWeather();
        //获取天气
        System.out.println("今日天气为："+weatherAdapter.getWeather());
        SpaceGreenhouseBlock SpaceGreenhouseBlock = new SpaceGreenhouseBlock();
        System.out.println("测试除虫方法：");
        //测试除虫方法
        weatherAdapter.disInsection(SpaceGreenhouseBlock);
        System.out.println("测试浇水方法：");
        //测试浇水方法
        weatherAdapter.watering(SpaceGreenhouseBlock);
    }
    public static void SEERAdapterTest(){
        SeerAdapter SEERAdapter = SeerAdapter.getInstance();
        System.out.println("现存赛尔豆："+SEERAdapter.getSeer());
        SEERAdapter.getSeerDou();
        SEERAdapter.getSpaceGreenhouseWarehouse();
        SEERAdapter.getSpaceGreenhouse();
        SEERAdapter.setSeerDou(1000.0);
        System.out.println("成功设置赛尔豆为：1000.0");
    }
    public static void main(String[] args) {
        AdapterTest test = new AdapterTest();
        test.WeatherTest();
    }
}
