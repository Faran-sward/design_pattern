package seerfarm.pattern.state.conc;

import seerfarm.common.seerfarmBlock;
import seerfarm.common.status.FarmBlockStatus;
import seerfarm.pattern.adapter.conc.WeatherAdapter;

import java.util.Set;

public class RainWeather extends WeatherAdapter {
    private final String weatherStatus="雨天";

    @Override
    public String getWeather() {
        return weatherStatus;
    }

    @Override
    public void watering(seerfarmBlock farmBlock) {
        System.out.println("下雨天还敢浇水，不怕烂根么！！！");
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
