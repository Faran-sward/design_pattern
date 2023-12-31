package SpaceGreenhouse.pattern.adapter.conc;


//import SpaceGreenhouse.pattern.adapter.Seer;

import framework.simplefactory.SEER;
import singletonlazyinitialization.SEERManor;
import SpaceGreenhouse.common.SpaceGreenhouse;
import SpaceGreenhouse.common.SpaceGreenhouseWarehouse;
import SpaceGreenhouse.pattern.adapter.Target;

/**
 * 赛尔角色适配器
 * 这里采用了单例模式(因为只有一个SEER)
 * 因为框架端没有农场，也没有仓库，所以要用适配器
 */
public class SeerAdapter extends SEER implements Target {

    private static SeerAdapter SEERAdapter=new SeerAdapter(SEERManor.getPlayer());

    //这个SEER对象要从外界传进来的，因为这是适配器
    private SEER SEER;

    private SpaceGreenhouse spaceGreenhouse = SpaceGreenhouse.getInstance();

    private SpaceGreenhouseWarehouse SpaceGreenhouseWarehouse;

    private SeerAdapter(SEER SEER){
        this.SEER=SEER;
        SpaceGreenhouseWarehouse=SpaceGreenhouseWarehouse.getInstance(SEER);
    }

    //返回SEER适配器对象实例
    public static SeerAdapter getInstance(){
        return SEERAdapter;
    }

    public static void setSeerAdapter(SeerAdapter SEERAdapter) {
        SeerAdapter.SEERAdapter = SEERAdapter;
    }

    @Override
    public Double getSeerDou() {
        return SEER.getMoney();
    }

    @Override
    public void setSeerDou(Double money) {
        SEER.setMoney(money);
    }

    public SEER getSeer() {
        return SEER;
    }

    public SpaceGreenhouse getSpaceGreenhouse() {
        return spaceGreenhouse;
    }

    public SpaceGreenhouseWarehouse getSpaceGreenhouseWarehouse() {
        return SpaceGreenhouseWarehouse;
    }
}
