package SpaceGreenhouse.pattern.factory;

import SpaceGreenhouse.common.exception.MyException;
import SpaceGreenhouse.common.exception.product.ProductNotFoundException;
import SpaceGreenhouse.common.status.other.ProductType;
import SpaceGreenhouse.common.utils.JsonOp;
import SpaceGreenhouse.pattern.factory.conc.CropsFactory;
import SpaceGreenhouse.pattern.factory.conc.FertilizerFactory;
import SpaceGreenhouse.pattern.factory.conc.SeedFactory;
import SpaceGreenhouse.pattern.factory.conc.ToolFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class SpaceGreenhouseProductFactory {
    final static String message = "对应的产品尚未加入赛尔号,敬请期待......";

    /**
     * @param name
     * @param <T>
     * @return
     * @throws MyException
     */
    public static <T> T createSpaceGreenhouseProduct(String name) throws ProductNotFoundException {
        List<String> crops = JsonOp.SearchJson(ProductType.CROPS);
        List<String> SpaceGreenhouseTool = JsonOp.SearchJson(ProductType.SpaceGreenhouse_TOOL);
        List<String> seed = JsonOp.SearchJson(ProductType.SEED);
        List<String> fertilizer = JsonOp.SearchJson(ProductType.FERTILIZER);
        if (crops.contains(name)) {
            return (T) CropsFactory.newInstance().create(name);
        } else if (SpaceGreenhouseTool.contains(name)) {
            return (T) ToolFactory.newInstance().create(name);
        } else if (seed.contains(name)) {
            return (T) SeedFactory.newInstance().create(name);
        } else if (fertilizer.contains(name)) {
            return (T) FertilizerFactory.newInstance().create(name);
        } else {
            throw new ProductNotFoundException(message);
        }
    }

    /**
     * 尽量不要用此方法，反射不是初衷，关键要使用工厂模式
     * 其他人在调接口的时候，可能只想传入name(虽然上面的方法有点多此一举就是了)
     *
     * @param tClass
     * @param <T>
     * @return
     * @throws MyException
     */
    public static <T> T createSpaceGreenhouseProduct(Class<T> tClass) throws ProductNotFoundException {
        T product = null;
        try {
            product = tClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new ProductNotFoundException(message);
        }
        return product;
    }

}
