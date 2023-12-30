package seerfarm.pattern.factory.conc;

import seerfarm.common.seerfarmWarehouse;
import seerfarm.common.exception.product.conc.ToolNotFoundException;
import seerfarm.common.product.AbstractTool;
import seerfarm.common.utils.JsonOp;
import seerfarm.pattern.adapter.conc.seerAdapter;
import seerfarm.pattern.factory.Factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 工具的抽象工厂类，此处不再写具体的，如ConcreteFarmToolFactory
 */
public class ToolFactory implements Factory {
    private seerAdapter SEER=seerAdapter.getInstance();

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
            Method method = seerfarmWarehouse.class.getDeclaredMethod("get" + name);
            final seerfarmWarehouse seerfarmWarehouse = SEER.getFarmWarehouse();
            AbstractTool invoke = (AbstractTool) method.invoke(seerfarmWarehouse);
            return invoke;
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new ToolNotFoundException(MSG);
        }
    }
}
