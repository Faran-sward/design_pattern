package seerfarm.pattern.state.conc;

import seerfarm.common.seerfarmBlock;
import seerfarm.common.status.FarmBlockStatus;
import seerfarm.pattern.adapter.conc.WeatherAdapter;

import java.util.Set;

public class CloudyWeather extends WeatherAdapter {
    private final String weatherStatus="阴天";

    @Override
    public String getWeather() {
        return weatherStatus;
    }
    @Override
    public void watering(seerfarmBlock farmBlock) {
        wateringCan.ToolBehavior();
        farmBlock.getBlockStatusSet().removeIf((s)->s.equals(FarmBlockStatus.DROUGHT));
    }

    @Override
    public void disInsection(seerfarmBlock farmBlock) {
        Set<FarmBlockStatus> blockStatusSet = farmBlock.getBlockStatusSet();
        if(blockStatusSet.removeIf(s->s.equals(FarmBlockStatus.INSECT_DISASTER))) {
            pesticide.ToolBehavior();
        }
        else{
            System.out.println("未发现作物受到害虫侵扰，请勿滥用农药");
        }
    }
}
