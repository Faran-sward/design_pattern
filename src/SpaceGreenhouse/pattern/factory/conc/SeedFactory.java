package SpaceGreenhouse.pattern.factory.conc;

import SpaceGreenhouse.common.exception.MyException;
import SpaceGreenhouse.common.exception.product.ProductNotFoundException;
import SpaceGreenhouse.common.exception.product.conc.SeedNotFoundException;
import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.common.utils.JsonOp;
import SpaceGreenhouse.pattern.factory.Factory;

/**
 * 种子抽象工厂类，此处不再写具体的，如CabbageSeedFactory
 */
public class SeedFactory implements Factory {
    private final static String PATH = JsonOp.getPathJson("SeedFactory");
    private final static String MSG = JsonOp.getMsgJson("SeedFactory");
    private static volatile SeedFactory seedFactory;

    private SeedFactory() {
    }

    /**
     * 单例模式
     *
     * @return
     */
    public synchronized static SeedFactory newInstance() {
        if (seedFactory == null) {
            seedFactory = new SeedFactory();
        }
        return seedFactory;
    }

    /**
     * 根据种子的名字生产对应的种子
     *
     * @param name
     * @return
     * @throws MyException
     */
    @Override
    public AbstractSeed create(String name) throws SeedNotFoundException {
        try {
            return Factory.createProduct(PATH + name);
        } catch (ProductNotFoundException e) {
            throw new SeedNotFoundException(MSG);
        }
    }
}

