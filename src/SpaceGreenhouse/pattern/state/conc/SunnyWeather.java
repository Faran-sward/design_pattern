package SpaceGreenhouse.pattern.state.conc;

import SpaceGreenhouse.common.SpaceGreenhouseBlock;
import SpaceGreenhouse.common.status.SpaceGreenhouseBlockStatus;
import SpaceGreenhouse.pattern.adapter.conc.WeatherAdapter;

import java.util.Set;

public class SunnyWeather extends WeatherAdapter {
    private final String weatherStatus="晴天";

    @Override
    public String getWeather() {
        return weatherStatus;
    }

    @Override
    public void watering(SpaceGreenhouseBlock SpaceGreenhouseBlock) {
        wateringCan.ToolBehavior();
        SpaceGreenhouseBlock.getBlockStatusSet().removeIf((s)->s.equals(SpaceGreenhouseBlockStatus.DROUGHT));
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
