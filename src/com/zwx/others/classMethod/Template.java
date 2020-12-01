package com.zwx.others.classMethod;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Template {
    public List<String> func(Setting setting){
        List<String> resList = new ArrayList<>();
        for (int i = 0; i < setting.getList().size(); i++) {
            String res = "";
            try{
                Class cur = setting.getList().get(i).getClass();
                Object a = setting.getList().get(i);

               /* // func 01
                Method method1 = cur.getMethod("getName");
                Method method2 = cur.getMethod("getAge");
                res += String.valueOf( method1.invoke(a)) + " is ";
                res +=  String.valueOf( method2.invoke(a)) + " years old ";*/

                Method method1 = cur.getMethod("getId");
                Method method2 = cur.getMethod("getNum");
                res += "id is : " + String.valueOf( method1.invoke(a)) + " || ";
                res += "num is :" + String.valueOf( method2.invoke(a)) ;
                resList.add(res);
            } catch (Exception e){
                e.printStackTrace();
            }
            //System.out.println("res = " + res);
        }
        return resList;
    }
}
