package SpaceGreenhouse.test.chainOfResponsibility;

import SpaceGreenhouse.common.product.AbstractFertilizer;
import SpaceGreenhouse.common.product.AbstractSeed;
import SpaceGreenhouse.common.product.fertilizer.AdvancedFertilizer;
import SpaceGreenhouse.common.product.seed.EggplantSeed;
import SpaceGreenhouse.pattern.chainOfResponsibility.conc.ShopHandler;
import SpaceGreenhouse.pattern.chainOfResponsibility.conc.WareHouseHandler;

import java.util.ArrayList;
import java.util.List;

public class ChainOfResponsibilityTest {
    public static void test(){
        List<AbstractSeed> seedList = new ArrayList<>();
        seedList.add(new EggplantSeed());
        System.out.println("----调用职责链模式ing----");
        //调用职责链模式
        WareHouseHandler wareHouseHandler = new WareHouseHandler();
        ShopHandler shopHandler = new ShopHandler();
        wareHouseHandler.setNext(shopHandler);
        System.out.println("尝试从仓库中调取一枚茄子种子......");
        wareHouseHandler.provideSeeds(seedList);
        System.out.println("成功为您从仓库中调取该种子！");
        List<AbstractFertilizer> fertilizerList = new ArrayList<>();
        int i=0;
        for(;i<10;i++){
            fertilizerList.add(new AdvancedFertilizer());
        }
        System.out.println("尝试从仓库中调取"+i+"份高级肥料......");
        try{
            wareHouseHandler.provideSeeds(fertilizerList);
            System.out.println("成功为您从仓库中调取该肥料！");
        }catch (Exception e){
            System.out.println("抱歉，赛尔豆余额不足，进货失败");
        }
    }
    public static void main(String[] args) {
        test();
    }
}
