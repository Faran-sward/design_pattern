package seerGame.commoditypackage.prototype;

/**
 * @author raoji
 * @date 2023/12/30
 * @Description
 */
public class Capsule extends Abstractshopping {
    public Capsule(){
        name = "精灵胶囊";
    }

    @Override
    public void manufacture() {
        try{
            System.out.println(name + "正在制作中...\n");
            Thread.sleep(1000);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name + "制作完成！");
    }
}
