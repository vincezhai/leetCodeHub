package com.zwx.leetcode.practice;

import com.zwx.learn.array.Array;

import java.util.*;

public class L_M_438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = findAnagrams(s,p);
        System.out.println("res = " + res);
    }

    // correct
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length() < p.length()){
            return list;
        }
        int sLength = s.length();
        int pLength = p.length();
        HashMap<Character,Integer> pMap = new HashMap<>();
        HashMap<Character,Integer> map = new HashMap<>();
        // calcu first window
        for (int i = 0; i < pLength; i++) {
            pMap.put(p.charAt(i),pMap.getOrDefault(p.charAt(i),0)+1);
            map.put(s.charAt(i) ,map.getOrDefault(s.charAt(i),0) + 1);
        }
        if(map.equals(pMap)){
            list.add(0);
        }
        // slide windows
        int left = 0;
        for (int right = p.length(); right < sLength; right++) {
            // 删除窗口左侧字母
            map.put(s.charAt(left), map.get(s.charAt(left)) - 1 );
            if(map.get(s.charAt(left)) == 0){
                map.remove(s.charAt(left));
            }
            left++;
            // 添加窗口右侧字母
            map.put(s.charAt(right) ,map.getOrDefault(s.charAt(right),0) + 1);
            if(map.equals(pMap)){
                list.add(left);
            }
        }
        return list;
    }


    // overtime
    public static List<Integer> findAnagramsOutTime(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int win = p.length();
        for (int i = 0; i < s.length() - win +1; i++) {
            if(compareStr(p,s.substring(i,i+win))){
                list.add(i);
            }
        }
        return list;
    }

    public static boolean compareStr(String a, String b){
        /*
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(Character ch : a.toCharArray()){
            map1.put(ch, map1.getOrDefault(ch,0) + 1);
        }
        for(Character ch : b.toCharArray()){
            map2.put(ch, map2.getOrDefault(ch,0) + 1);
        }
        return map1.equals(map2);
        */

        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < a.length(); i++) {
            if(ch1[i] != ch2[i]){
                return false;
            }
        }
        return true;
    }
}
