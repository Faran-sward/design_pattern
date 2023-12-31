package SpaceGreenhouse.pattern.factory.conc;

import SpaceGreenhouse.common.SpaceGreenhouseWarehouse;
import SpaceGreenhouse.common.exception.product.conc.ToolNotFoundException;
import SpaceGreenhouse.common.product.AbstractTool;
import SpaceGreenhouse.common.utils.JsonOp;
import SpaceGreenhouse.pattern.adapter.conc.SeerAdapter;
import SpaceGreenhouse.pattern.factory.Factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 工具的抽象工厂类，此处不再写具体的，如ConcreteSpaceGreenhouseToolFactory
 */
public class ToolFactory implements Factory {
    private SeerAdapter SEER=SeerAdapter.getInstance();

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
            Method method = SpaceGreenhouseWarehouse.class.getDeclaredMethod("get" + name);
            final SpaceGreenhouseWarehouse SpaceGreenhouseWarehouse = SEER.getSpaceGreenhouseWarehouse();
            AbstractTool invoke = (AbstractTool) method.invoke(SpaceGreenhouseWarehouse);
            return invoke;
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new ToolNotFoundException(MSG);
        }
    }
}
