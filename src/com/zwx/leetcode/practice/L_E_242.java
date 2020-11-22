package com.zwx.leetcode.practice;

public class L_E_242 {
    public static void main(String[] args) {
        System.out.println( isAnagram("abc","acz") );
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length() ; i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        for (int cur : table) {
            if(cur != 0){
                return false;
            }
        }
        return true;
    }
}
