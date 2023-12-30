package seerfarm.pattern.adapter;

/**
 * 适配器模式中的目标接口
 */
public interface Target {

    default Double getSeerDou(){return null;}

    default void setSeerDou(Double money){}

    default String getWeather() {return null;}
}
