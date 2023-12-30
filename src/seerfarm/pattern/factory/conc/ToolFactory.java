package seerfarm.pattern.factory.conc;

import seerfarm.common.SeerFarmWarehouse;
import seerfarm.common.exception.product.conc.ToolNotFoundException;
import seerfarm.common.product.AbstractTool;
import seerfarm.common.utils.JsonOp;
import seerfarm.pattern.adapter.conc.SeerAdapter;
import seerfarm.pattern.factory.Factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 工具的抽象工厂类，此处不再写具体的，如ConcreteFarmToolFactory
 */
public class ToolFactory implements Factory {
    private SeerAdapter seer=SeerAdapter.getInstance();

    private final static String PATH = JsonOp.getPathJson("ToolFactory");

    private final static String MSG = JsonOp.getMsgJson("ToolFactory");

    private static volatile ToolFactory toolFactory;

    private ToolFactory() {
    }

    public synchronized static ToolFactory newInstance() {
        if (toolFactory == null) {
            toolFactory = new ToolFactory();
        }
        return toolFactory;
    }

    @Override
    public AbstractTool create(String name) throws ToolNotFoundException {
        try {
            Method method = SeerFarmWarehouse.class.getDeclaredMethod("get" + name);
            final SeerFarmWarehouse seerFarmWarehouse = seer.getFarmWarehouse();
            AbstractTool invoke = (AbstractTool) method.invoke(seerFarmWarehouse);
            return invoke;
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new ToolNotFoundException(MSG);
        }
    }
}
