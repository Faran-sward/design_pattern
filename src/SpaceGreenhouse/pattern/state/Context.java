package SpaceGreenhouse.pattern.state;

import SpaceGreenhouse.common.SpaceGreenhouseBlock;
import SpaceGreenhouse.pattern.adapter.conc.WeatherAdapter;

public class Context {
    //当前天气状态
    private WeatherAdapter weather;
    //选取的太空温室块
    private SpaceGreenhouseBlock SpaceGreenhouseBlock;

    public Context(WeatherAdapter weather, SpaceGreenhouseBlock SpaceGreenhouseBlock){
        this.SpaceGreenhouseBlock=SpaceGreenhouseBlock;
        this.weather = weather;
    }
    //浇水
    public void watering() {
        weather.watering(SpaceGreenhouseBlock);
    }
    //除虫
    public void disInsection(){
        weather.disInsection(SpaceGreenhouseBlock);
    }
}
