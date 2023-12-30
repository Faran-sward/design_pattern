package seerfarm.pattern.adapter.conc;

import seerfarm.common.seerfarmBlock;
import seerfarm.common.product.tool.Pesticide;
import seerfarm.common.product.tool.WateringCan;
import seerfarm.pattern.adapter.Target;
import seerfarm.pattern.adapter.Weather;
import seerfarm.pattern.state.conc.CloudyWeather;
import seerfarm.pattern.state.conc.InsectDamageWeather;
import seerfarm.pattern.state.conc.RainWeather;
import seerfarm.pattern.state.conc.SunnyWeather;

import java.util.Random;

/**
 * 天气适配器
 */
public class WeatherAdapter extends Weather implements Target {

    public static seerAdapter SEER=seerAdapter.getInstance();

    public static WateringCan wateringCan= SEER.getFarmWarehouse().getWateringCan();

    public static Pesticide pesticide= SEER.getFarmWarehouse().getPesticide();

    public static WeatherAdapter adapter;
    //随机跳转天气
    public static WeatherAdapter changeWeather(){
        Random random = new Random();
        int ran = random.nextInt(4);
        if(ran==0) {
            return new SunnyWeather();
        }else if(ran==1){
            return new RainWeather();
        }else if(ran==2){
            return new InsectDamageWeather();
        }
        else {
            return new CloudyWeather();
        }
    }
    /**
     * 获取天气
     * @return
     */
    @Override
    public String getWeather() {
        return getWeatherStatus();
    }
    public static WeatherAdapter getInstance(){
        return adapter;
    }

    public void watering(seerfarmBlock farmBlock){}

    public void disInsection(seerfarmBlock farmBlock){}
}
