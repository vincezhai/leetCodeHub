package com.zwx.leetcode.string;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import com.zwx.learn.array.Array;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/*
去重算法：
Set：单纯去重，使用set，利用set元素唯一性，传进去就没有重复的
contain：创建新的list，遍历一边旧list，如果新列表中没有就传进新列表，最后得到没有重复的
stream流：List list=(List) a.stream().distinct().collect(Collectors.toList());

排序算法：
Arrays.sort：转成数组进行排序。
Collections.sort 去重
stream().sorted():用流去重

流：
https://blog.csdn.net/qing_gee/article/details/105238960
*/

public class L_E_929 {
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(f1(emails));

        //List list = Arrays.stream(emails).map(s -> s.substring(0,s.indexOf("+"))).map(s -> s.replace(".","")).distinct().collect(Collectors.toList());
        //System.out.println(list);

        System.out.println("***************");

        //nothing
        List<Integer> test = Arrays.asList(1,2,3,8,4,6,4,7);
        System.out.println(test);
        Collections.sort(test);
        System.out.println(test);

        System.out.println(test.stream().filter(s -> s>5).limit(2).collect(Collectors.toList()));
        System.out.println(test.stream().sorted().distinct().collect(Collectors.toList()));

    }

    public static int f1(String[] emails){
        Set<String> res = new HashSet<>();
        for(String email : emails){
            String[] s = email.split("@");
            String local = s[0];
            String domain = s[1];
            if(local.contains("+")){
                local = local.substring(0,local.indexOf("+"));
            }
            local = local.replace(".","");
            res.add(local + "@" + domain);
        }
        Arrays.sort(res.toArray());
        return res.size();

        //通过set去重
        /*Set set = new HashSet(res);
        List output = new ArrayList(set);
        return output.size();*/


        //通过新的list去重
        /*List<String> descList = new ArrayList<String>();
        for(String str : res){
            if(!descList.contains(str))
                descList.add(str);
        }
        return descList.size();*/
    }
}
