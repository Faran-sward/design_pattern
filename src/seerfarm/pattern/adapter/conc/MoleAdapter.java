package seerfarm.pattern.adapter.conc;


//import seerfarm.pattern.adapter.SEER;

import framework.simplefactory.SEER;
import singletonlazyinitialization.seerManor;
import seerfarm.common.seerfarm;
import seerfarm.common.seerfarmWarehouse;
import seerfarm.pattern.adapter.Target;

/**
 * 摩尔角色适配器
 * 这里采用了单例模式(因为只有一个seer)
 * 因为框架端没有农场，也没有仓库，所以要用适配器
 */
public class seerAdapter extends SEER implements Target {

    private static seerAdapter seerAdapter=new seerAdapter(seerManor.getPlayer());

    //这个seer对象要从外界传进来的，因为这是适配器
    private SEER SEER;

    private seerfarm seerfarm=seerfarm.getInstance();

    private seerfarmWarehouse farmWarehouse;

    private seerAdapter(SEER SEER){
        this.SEER=SEER;
        farmWarehouse=seerfarmWarehouse.getInstance(SEER);
    }

    //返回seer适配器对象实例
    public static seerAdapter getInstance(){
        return seerAdapter;
    }

    public static void setseerAdapter(seerAdapter seerAdapter) {
        seerAdapter.seerAdapter = seerAdapter;
    }

    @Override
    public Double getseerDou() {
        return SEER.getMoney();
    }

    @Override
    public void setseerDou(Double money) {
        SEER.setMoney(money);
    }

    public SEER getseer() {
        return SEER;
    }

    public seerfarm getseerfarm() {
        return seerfarm;
    }

    public seerfarmWarehouse getFarmWarehouse() {
        return farmWarehouse;
    }
}
