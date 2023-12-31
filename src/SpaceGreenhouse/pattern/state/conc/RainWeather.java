package SpaceGreenhouse.pattern.state.conc;

import SpaceGreenhouse.common.SpaceGreenhouseBlock;
import SpaceGreenhouse.common.status.SpaceGreenhouseBlockStatus;
import SpaceGreenhouse.pattern.adapter.conc.WeatherAdapter;

import java.util.Set;

public class RainWeather extends WeatherAdapter {
    private final String weatherStatus="雨天";

    @Override
    public String getWeather() {
        return weatherStatus;
    }

    @Override
    public void watering(SpaceGreenhouseBlock SpaceGreenhouseBlock) {
        System.out.println("下雨天还敢浇水，不怕烂根么！！！");
    }

    @Override
    public void disInsection(SpaceGreenhouseBlock SpaceGreenhouseBlock) {
        Set<SpaceGreenhouseBlockStatus> blockStatusSet = SpaceGreenhouseBlock.getBlockStatusSet();
        if(blockStatusSet.removeIf(s->s.equals(SpaceGreenhouseBlockStatus.INSECT_DISASTER))) {
            pesticide.ToolBehavior();
        }
        else{
            System.out.println("未发现作物受到害虫侵扰，请勿滥用农药");
        }
    }
}
