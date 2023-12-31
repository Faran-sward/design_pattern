package SpaceGreenhouse.pattern.chainOfResponsibility.conc;

import SpaceGreenhouse.common.product.IProduct;
import SpaceGreenhouse.pattern.chainOfResponsibility.Handler;

import java.util.List;

/**
 * 商店
 * 接收者
 */
public class ShopHandler extends Handler {
    @Override
    public <T extends IProduct> boolean provideSeeds(List<T> list) {
        for (T item : list) {
            Double price = item.getPrice();
            if (SEER.getSeerDou() < price) {
                System.out.println("抱歉，塞尔豆不足，进货失败");
                return false;
            } else {
                double newPrice = SEER.getSeerDou() - price;
                SEER.setMoney(newPrice);
            }
        }
        System.out.println("进货成功！");
        return true;
    }
}
