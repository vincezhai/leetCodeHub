package leetcode.test.reflectTest;

import java.util.Arrays;

// 使用注解 维护 转换表
@NeedConverted(strField = {"friend","num"} , listField = {"friendList","numList"} )
public class EntityCopy {
    private String name1 = "vince";
    private String name2 = "ALL";

    private String other = "ALL";
    private String city = "jz";

    private int age = 25;

    private String friend = "a,b,c,d,e";
    private String[] friendList;

    private String num = "1,2,3,4";
    private String[] numList;

    @Override
    public String toString() {
        return "EntityCopy{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", other='" + other + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", friend='" + friend + '\'' +
                ", friendList=" + Arrays.toString(friendList) +
                ", num='" + num + '\'' +
                ", numList=" + Arrays.toString(numList) +
                '}';
    }
}
