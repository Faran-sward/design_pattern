package SpaceGreenhouse.pattern.state.conc;

import SpaceGreenhouse.common.SpaceGreenhouseBlock;
import SpaceGreenhouse.common.status.SpaceGreenhouseBlockStatus;
import SpaceGreenhouse.pattern.adapter.conc.WeatherAdapter;

public class InsectDamageWeather extends WeatherAdapter {
    private final String weatherStatus="虫灾";

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
        if (SpaceGreenhouseBlock.getBlockStatusSet().removeIf(s -> s.equals(SpaceGreenhouseBlockStatus.INSECT_DISASTER))) {
            pesticide.ToolBehavior();
        } else {
            System.out.println("就算是虫灾天，喷洒农药也要适量哦");
        }
    }
}
