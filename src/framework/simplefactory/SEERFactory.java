package framework.simplefactory;

// chatroom,seermaner
public class SEERFactory {
    //创建并初始化角色
    public SEER createSEER(String role,String color){
        SEERIngredientFactory seerIngredientFactory=new SEERIngredientFactory();
        SEER seer=new SEER();
        seer.setSEERRole(seerIngredientFactory.setRole(role));
        seer.setSEERColor(seerIngredientFactory.setColor(color));
        seer.setSEERName(color+role);
        return seer;
    }
}
