package com.zwx.leetcode.design;

import java.util.HashMap;

public class WordsFrequency {
    private HashMap<String,Integer> map;
    public WordsFrequency(String[] book) {
        map = new HashMap<>();
        for(String word : book){
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            } else {
                map.put(word,1);
            }
        }
    }

    public int get(String word) {
        if(map == null || !map.containsKey(word)){
            System.out.println("res = " + 0);
            return 0;
        }
        int res = map.get(word);
        System.out.println("res = " + res);
        return res;
    }
}
