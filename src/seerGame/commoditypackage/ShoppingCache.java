package seerGame.commoditypackage;

import seerGame.commoditypackage.prototype.Abstractshopping;
import seerGame.commoditypackage.prototype.Capsule;
import seerGame.commoditypackage.prototype.Ppyao;
import seerGame.commoditypackage.prototype.Shangyao;

import java.util.Hashtable;

/**
 * @author raoji
 * @date 2023/12/30
 * @Description
 */
public class ShoppingCache {
    private static Hashtable<String, Abstractshopping> goodsMap = new Hashtable<String, Abstractshopping>();


    /**
     * 获取克隆对象
     * @param goodsID
     * @return
     */
    public static Abstractshopping getCommodity(String goodsID) {
        Abstractshopping cachedCommodity = goodsMap.get(goodsID);
        if (cachedCommodity == null) {return null;}
        return (Abstractshopping) cachedCommodity.clone();
    }


    /**
     * 在数据库中加载商品
     * goodsMap.put(commodityKey, commodity);
     */

    public static void loadCache() {

        Shangyao shangyao = new Shangyao();
        shangyao.setId("1");
        goodsMap.put(shangyao.getId(), shangyao);

        Capsule capsule = new Capsule();
        capsule.setId("2");
        goodsMap.put(capsule.getId(), capsule);

        Ppyao ppyao = new Ppyao();
        ppyao.setId("3");
        goodsMap.put(ppyao.getId(), ppyao);
    }
}
