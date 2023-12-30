package seerfarm.pattern.observer;

import seerfarm.common.seerfarm;
import seerfarm.common.status.FarmBlockStatus;
import seerfarm.pattern.adapter.conc.seerAdapter;
import seerfarm.pattern.adapter.conc.WeatherAdapter;
import seerfarm.pattern.iterator.conc.FarmIterator;

import java.util.Set;

/**
 * 天气状态
 */
public class WeatherObserver {

    private seerAdapter SEER=seerAdapter.getInstance();

    private seerfarm seerfarm = SEER.getseerfarm();

    private WeatherObserver(){
    }

    public static WeatherObserver getInstance(){
        return new WeatherObserver();
    }
    /**
     * 观察天气
     */
    public void observer(WeatherAdapter weatherAdapter) {
        if ("雨天".equals(weatherAdapter.getWeather())) {
            //下雨天去除干旱状态
            FarmIterator iterator = seerfarm.getIterator();
            while (iterator.hasNext()) {
                Set<FarmBlockStatus> statusSet = iterator.next().getBlockStatusSet();
                statusSet.remove(FarmBlockStatus.DROUGHT);
            }
        } else if ("虫灾".equals(weatherAdapter.getWeather())) {
            FarmIterator iterator = seerfarm.getIterator();
            while (iterator.hasNext()) {
                Set<FarmBlockStatus> statusSet = iterator.next().getBlockStatusSet();
                statusSet.add(FarmBlockStatus.INSECT_DISASTER);
            }
        }
    }

}
