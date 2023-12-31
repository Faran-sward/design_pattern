package SpaceGreenhouse.pattern.chainOfResponsibility;

import SpaceGreenhouse.common.SpaceGreenhouseWarehouse;
import SpaceGreenhouse.common.product.IProduct;
import SpaceGreenhouse.pattern.adapter.conc.SeerAdapter;

import java.util.List;

/**
 * 职责链模式
 * 任务接收者抽象类
 */
public abstract class Handler {
    protected SeerAdapter SEER=SeerAdapter.getInstance();

    protected SpaceGreenhouseWarehouse SpaceGreenhouseWarehouse = SEER.getSpaceGreenhouseWarehouse();

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
