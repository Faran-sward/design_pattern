package seerGame.commoditypackage.prototype;

/**
 * @author raoji
 * @date 2023/12/30
 * @Description
 */
public class Ppyao extends Abstractshopping {

    public Ppyao(){
        name = "技能恢复药";
    }

    @Override
    public void manufacture() {
        try{
            System.out.println(name + "正在制作中...\n");
            Thread.sleep(3000);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name + "制作完毕！");
    }
}
