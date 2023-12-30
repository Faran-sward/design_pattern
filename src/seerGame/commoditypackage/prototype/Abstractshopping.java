package seerGame.commoditypackage.prototype;

/**
 * 原型模式
 */

/**
 * @author xcl
 * @date 2023/12/30
 * @Description
 */
public abstract class Abstractshopping implements Cloneable {

    private String id;
    protected String name;

    /**
     * 接口
     */
    public abstract void manufacture();

    public String getname(){
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    /**
     * 克隆对象
     * @return
     */
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
