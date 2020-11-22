package com.zwx.leetcode.hashmap;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import com.zwx.learn.array.Array;

import java.util.*;

public class L_E_884 {
    public static void main(String[] args) {
        String a ="this apple is sweet";
        String b ="this apple is sour is";
        System.out.println("f1(a,b) = " + Arrays.toString( f1(a, b)));
    }

    public static String[] f1(String A, String B){
        String[] a = A.trim().split(" ");
        String[] b = B.trim().split(" ");
        HashMap<String,Integer> mapA = new HashMap<>();
        HashMap<String,Integer> mapB = new HashMap<>();
        for(String str : a){
            if(mapA.containsKey(str)){
                mapA.put(str,mapA.get(str)+1);
            }else {
                mapA.put(str,1);
            }
        }
        for(String str : b){
            mapB.put(str,mapB.getOrDefault(str,0));
        }
        System.out.println("mapB = " + mapB);


        /*for(String str : b){
            if(mapB.containsKey(str)){
                mapB.put(str,mapB.get(str)+1);
            }else {
                mapB.put(str,1);
            }
        }*/

        List<String> list = new ArrayList<>();
        Iterator iterator = mapA.keySet().iterator();
        while(iterator.hasNext()){
            String key =(String)iterator.next();
            Integer val = mapA.get(key);
            if(val==1 && !mapB.containsKey(key)){
                list.add(key);
            }
        }

        Iterator iter = mapB.keySet().iterator();
        while(iter.hasNext()){
            String key =(String)iter.next();
            Integer val = mapB.get(key);
            if(val==1 && !mapA.containsKey(key)){
                list.add(key);
            }
        }
        String[] res = new String[list.size()];
        return list.toArray(res) ;
    }
}
