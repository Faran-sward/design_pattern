package seerGame.test;

import seerGame.diggingpackage.template.AbstractDigging;
import seerGame.diggingpackage.template.DepthDiggging;
import seerGame.diggingpackage.template.SafeDigging;
import seerGame.diggingpackage.template.SpeedDigging;
import singletonlazyinitialization.SEERManor;

/**
 * @author raoji
 * @date 2023/12/30
 * @Description
 */

public class TemplateTest {

    /**
     * @test
     */
    public static void test(){
        System.out.println("----调用模板模式ing----");

        SEERManor moleManor = SEERManor.getInstance();
        moleManor.test();
        AbstractDigging r1 = new SpeedDigging();
        AbstractDigging r2 = new DepthDiggging();
        AbstractDigging r3 = new SafeDigging();
        System.out.println("\n正在进行显示挖掘...");
        r1.test();
        System.out.println("\n正在进行深层挖掘...");
        r2.test();
        System.out.println("\n正在进行障碍挖掘...");
        r3.test();

    }

    public static void main(String[] args) {
        TemplateTest.test();
    }
}

