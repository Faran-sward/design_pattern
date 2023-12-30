package seerfarm.pattern.state;

import seerfarm.common.seerfarmBlock;
import seerfarm.pattern.adapter.conc.WeatherAdapter;

public class Context {
    //当前天气状态
    private WeatherAdapter weather;
    //选取的农田块
    private seerfarmBlock farmBlock;

    public Context(WeatherAdapter weather, seerfarmBlock farmBlock){
        this.farmBlock=farmBlock;
        this.weather = weather;
    }
    //浇水
    public void watering() {
        weather.watering(farmBlock);
    }
    //除虫
    public void disInsection(){
        weather.disInsection(farmBlock);
    }
}
