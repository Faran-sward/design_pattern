package seerfarm.pattern.adapter.conc;


//import seerfarm.pattern.adapter.Seer;

import framework.simplefactory.Seer;
import singletonlazyinitialization.SeerManor;
import seerfarm.common.SeerFarm;
import seerfarm.common.SeerFarmWarehouse;
import seerfarm.pattern.adapter.Target;

/**
 * 赛尔角色适配器
 * 这里采用了单例模式(因为只有一个seer)
 * 因为框架端没有农场，也没有仓库，所以要用适配器
 */
public class SeerAdapter extends Seer implements Target {

    private static SeerAdapter seerAdapter=new SeerAdapter(SeerManor.getPlayer());

    //这个seer对象要从外界传进来的，因为这是适配器
    private Seer seer;

    private SeerFarm seerFarm=SeerFarm.getInstance();

    private SeerFarmWarehouse farmWarehouse;

    private SeerAdapter(Seer seer){
        this.seer=seer;
        farmWarehouse=SeerFarmWarehouse.getInstance(seer);
    }

    //返回seer适配器对象实例
    public static SeerAdapter getInstance(){
        return seerAdapter;
    }

    public static void setSeerAdapter(SeerAdapter seerAdapter) {
        SeerAdapter.seerAdapter = seerAdapter;
    }

    @Override
    public Double getSeerDou() {
        return seer.getMoney();
    }

    @Override
    public void setSeerDou(Double money) {
        seer.setMoney(money);
    }

    public Seer getSeer() {
        return seer;
    }

    public SeerFarm getSeerFarm() {
        return seerFarm;
    }

    public SeerFarmWarehouse getFarmWarehouse() {
        return farmWarehouse;
    }
}
