package leetcode.test.reflectTest;

import java.util.Arrays;

// 使用注解 维护 转换表
@NeedConverted(strField = {"friend","num","something"} , listField = {"friendList","numList","somethings"} )
public class Entity {
    private String name1 = "vince";
    private String name2 = "ALL";

    private int age = 25;

    private String friend = "a,b,c,d,e";
    private String[] friendList;

    private String num = "1,2,3,4";
    private String[] numList;

    private String something = "11,22,33,44";
    private String[] somethings;

    @Override
    public String toString() {
        return "Entity{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", age=" + age +
                ", friend='" + friend + '\'' +
                ", friendList=" + Arrays.toString(friendList) +
                ", num='" + num + '\'' +
                ", numList=" + Arrays.toString(numList) +
                ", something='" + something + '\'' +
                ", somethings=" + Arrays.toString(somethings) +
                '}';
    }
}
