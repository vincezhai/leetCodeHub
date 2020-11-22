package com.zwx.leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L_E_1002 {
    public static void main(String[] args) {
        String[] strArray = {"bella","label","roller"};
        System.out.println("f1(strArray) = " + f1(strArray));
    }

    public static List<String> f1(String[] A){
        List<String> res = new ArrayList<>();
        HashMap<Character,Integer> judge = new HashMap();
        for (int i = 0; i < A[0].length() ; i++) {
            if(judge.containsKey(A[0].charAt(i))){
                judge.put(A[0].charAt(i),judge.get(A[0].charAt(i))+1);
            } else {
                judge.put(A[0].charAt(i),1);
            }
        }

        for (int j = 1; j < A.length; j++) {
            //build hash
            HashMap<Character,Integer> map = new HashMap();
            for (int i = 0; i < A[j].length() ; i++) {
                if(map.containsKey(A[j].charAt(i)) ) {
                    map.put(A[j].charAt(i),map.get(A[j].charAt(i))+1);
                }else {
                    if(judge.containsKey(A[j].charAt(i))){
                        map.put(A[j].charAt(i),1);
                    }
                }
            }

            //min
            for(Map.Entry<Character,Integer> entry : judge.entrySet()){
                char ch = entry.getKey();
                int value = entry.getValue();
                if(map.containsKey(ch)){
                    if(map.get(ch)<value){
                        judge.put(ch,map.get(ch));
                    }
                }else {
                    judge.put(ch,0);
                }
            }
        }

        for(Map.Entry<Character,Integer> entry : judge.entrySet()){
            char ch = entry.getKey();
            int value = entry.getValue();
            for (int i = 0; i < value ; i++) {
                    res.add(ch+"");
                }
            }

        return res;
    }
}
