package framework.simplefactory;

import framework.simplefactory.color.*;
import framework.simplefactory.role.*;

public class SEERIngredientFactory {
    //设置角色
    public Role setRole(String role){
        if(role==null){
            return null;
        }
        if(role.equalsIgnoreCase("发明家肖恩")){
            return new Xiaoen();
        }
        else if(role.equalsIgnoreCase("派特博士")){
            return new Paite();
        }
        else if(role.equalsIgnoreCase("机械师爱丽丝")){
            return new Ailisi();
        }
        else if(role.equalsIgnoreCase("雷蒙教官")){
            return new Leimeng();
        }
        return null;
    }

    //设置颜色
    public Color setColor(String color){
        if(color==null){
            return null;
        }
        if(color.equalsIgnoreCase("Red")){
            return new Red();
        }
        else if(color.equalsIgnoreCase("Green")){
            return new Green();
        }
        else if(color.equalsIgnoreCase("Blue")){
            return new Blue();
        }
        else if(color.equalsIgnoreCase("Pink")){
            return new Pink();
        }
        return null;
    }

}
