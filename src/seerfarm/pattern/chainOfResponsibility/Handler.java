package seerfarm.pattern.chainOfResponsibility;

import seerfarm.common.seerfarmWarehouse;
import seerfarm.common.product.IProduct;
import seerfarm.pattern.adapter.conc.seerAdapter;

import java.util.List;

/**
 * 职责链模式
 * 任务接收者抽象类
 */
public abstract class Handler {
    protected seerAdapter SEER=seerAdapter.getInstance();

    protected seerfarmWarehouse farmWarehouse = SEER.getFarmWarehouse();

    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    //处理请求的方法
    public abstract <T extends IProduct> boolean provideSeeds(List<T> list);
}
