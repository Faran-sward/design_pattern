package SpaceGreenhouse.pattern.observer;

import SpaceGreenhouse.common.SpaceGreenhouse;
import SpaceGreenhouse.common.status.SpaceGreenhouseBlockStatus;
import SpaceGreenhouse.pattern.adapter.conc.SeerAdapter;
import SpaceGreenhouse.pattern.adapter.conc.WeatherAdapter;
import SpaceGreenhouse.pattern.iterator.conc.SpaceGreenhouseIterator;

import java.util.Set;

/**
 * 天气状态
 */
public class WeatherObserver {

    private SeerAdapter SEER=SeerAdapter.getInstance();

    private SpaceGreenhouse SpaceGreenhouse = SEER.getSpaceGreenhouse();

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
            SpaceGreenhouseIterator iterator = SpaceGreenhouse.getIterator();
            while (iterator.hasNext()) {
                Set<SpaceGreenhouseBlockStatus> statusSet = iterator.next().getBlockStatusSet();
                statusSet.remove(SpaceGreenhouseBlockStatus.DROUGHT);
            }
        } else if ("虫灾".equals(weatherAdapter.getWeather())) {
            SpaceGreenhouseIterator iterator = SpaceGreenhouse.getIterator();
            while (iterator.hasNext()) {
                Set<SpaceGreenhouseBlockStatus> statusSet = iterator.next().getBlockStatusSet();
                statusSet.add(SpaceGreenhouseBlockStatus.INSECT_DISASTER);
            }
        }
    }

}
