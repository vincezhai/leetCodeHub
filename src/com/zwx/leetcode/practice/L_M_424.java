package com.zwx.leetcode.practice;

import java.util.HashMap;

public class L_M_424 {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        int res = characterReplacement(s,k);
        System.out.println("res = " + res);
    }

    public static int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int left = 0;
        int winMax = 0;
        int res = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(chars[right],map.getOrDefault(chars[right],0) + 1);
            winMax = Math.max(winMax ,map.get(chars[right]));
            if( winMax + k  < right - left + 1 ){
                map.put( chars[left] ,map.get(chars[left])-1 );
                left++;
            }
            res = Math.max(res,right - left + 1);
        }
        return res;
    }
}