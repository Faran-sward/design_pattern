package seerfarm.test.adapter;

import framework.simplefactory.SEER;
import seerfarm.common.seerfarmBlock;
import seerfarm.pattern.adapter.conc.seerAdapter;
import seerfarm.pattern.adapter.conc.WeatherAdapter;

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
        seerfarmBlock seerfarmBlock = new seerfarmBlock();
        System.out.println("测试除虫方法：");
        //测试除虫方法
        weatherAdapter.disInsection(seerfarmBlock);
        System.out.println("测试浇水方法：");
        //测试浇水方法
        weatherAdapter.watering(seerfarmBlock);
    }
    public static void seerAdapterTest(){
        seerAdapter seerAdapter = seerAdapter.getInstance();
        System.out.println("现存摩尔豆："+seerAdapter.getseer());
        seerAdapter.getseerDou();
        seerAdapter.getFarmWarehouse();
        seerAdapter.getseerfarm();
        seerAdapter.setseerDou(1000.0);
        System.out.println("成功设置摩尔豆为：1000.0");
    }
    public static void main(String[] args) {
        AdapterTest test = new AdapterTest();
        test.WeatherTest();
    }
}
