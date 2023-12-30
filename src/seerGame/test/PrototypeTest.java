package seerGame.test;

import seerGame.commoditypackage.ShoppingCache;
import seerGame.commoditypackage.prototype.Abstractshopping;

/**
 * @author raoji
 * @date 2023/12/30
 * @Description
 */
public class PrototypeTest {

    /**
     * @test
     */
    public static void test() {
        System.out.println("----调用原型模式ing----");

        ShoppingCache.loadCache();
        Abstractshopping clonedmeal1 = (Abstractshopping) ShoppingCache.getCommodity("1");
        clonedmeal1.manufacture();
        Abstractshopping clonedmeal2 = (Abstractshopping) ShoppingCache.getCommodity("2");
        clonedmeal2.manufacture();
        Abstractshopping clonedmeal3 = (Abstractshopping) ShoppingCache.getCommodity("3");
        clonedmeal3.manufacture();

    }

    public static void main(String[] args) {
        PrototypeTest.test();
    }
}