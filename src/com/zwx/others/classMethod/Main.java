package com.zwx.others.classMethod;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //System.out.println("func1() = " + func1());
        System.out.println();
        System.out.println("func2() = " + func2());
    }

    private static List<String> func1() {
        Setting setting = new Setting();
        List<EntityX> list = new ArrayList<>();

        EntityX entityX01 = new EntityX();
        entityX01.setAge("18");
        entityX01.setName("Tom");

        EntityX entityX02 = new EntityX();
        entityX02.setAge("28");
        entityX02.setName("Tommy");

        list.add(entityX01);
        list.add(entityX02);

        setting.setList(list);
        Template template = new Template();
        return template.func(setting);
    }

    private static List<String> func2() {
        Setting setting = new Setting();
        List<EntityY> list = new ArrayList<>();

        EntityY entityY01 = new EntityY();
        entityY01.setId("s170");
        entityY01.setNum("32");

        EntityY entityY02 = new EntityY();
        entityY02.setId("s170170");
        entityY02.setNum("3232");

        list.add(entityY01);
        list.add(entityY02);

        setting.setList(list);
        Template template = new Template();
        return template.func(setting);
    }

}
