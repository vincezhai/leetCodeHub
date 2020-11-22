package com.zwx.leetcode.practice;

import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L_M_3 {
    public static void main(String[] args) {
        // test for git
        String s = "abba";
        int res = lengthOfLongestSubstring(s);
        System.out.println("res = " + res);
    }

    public static int lengthOfLongestSubstring(String s) {

        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int length = s.length();
        char[] arr = s.toCharArray();
        int left = 0;
        for (int right = 0; right < length; right++) {
            if(map.containsKey(arr[right])){
                left = map.get(arr[right]) + 1;
                //left = Math.max(left, map.get(arr[right]) + 1);
            }
            map.put(arr[right],right);
            max = Math.max(max,right - left +1);
        }
        return max;
    }
    public int lengthOfLongestSubstring0(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int max = 1;
        char[] arr = s.toCharArray();
        int length = s.length();
        int right = 1;
        int left = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for ( ;right < length;right++) {
            //List<Character> tmp = new ArrayList<>();
            if (map.containsKey(arr[right])) {
                left = Math.max(left,map.get(arr[right]) + 1);
                map.put(arr[right], right);
            } else {
                map.put(arr[right], right);
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}
//abba