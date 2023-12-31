package SpaceGreenhouse.pattern.adapter.conc;

import SpaceGreenhouse.common.SpaceGreenhouseBlock;
import SpaceGreenhouse.common.product.tool.Pesticide;
import SpaceGreenhouse.common.product.tool.WateringCan;
import SpaceGreenhouse.pattern.adapter.Target;
import SpaceGreenhouse.pattern.adapter.Weather;
import SpaceGreenhouse.pattern.state.conc.CloudyWeather;
import SpaceGreenhouse.pattern.state.conc.InsectDamageWeather;
import SpaceGreenhouse.pattern.state.conc.RainWeather;
import SpaceGreenhouse.pattern.state.conc.SunnyWeather;

import java.util.Random;

/**
 * 天气适配器
 */
public class WeatherAdapter extends Weather implements Target {

    public static SeerAdapter SEER=SeerAdapter.getInstance();

    public static WateringCan wateringCan= SEER.getSpaceGreenhouseWarehouse().getWateringCan();

    public static Pesticide pesticide= SEER.getSpaceGreenhouseWarehouse().getPesticide();

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

    public void watering(SpaceGreenhouseBlock SpaceGreenhouseBlock){}

    public void disInsection(SpaceGreenhouseBlock SpaceGreenhouseBlock){}
}
