package com.zwx.leetcode.twoPoint;

import java.util.Arrays;
import java.util.HashMap;

public class L_M_424 {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;

        int res = characterReplacement(s,k);
        System.out.println("res = " + res);

        //System.out.println("f(s,k) = " + f(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int max = 0;
        char[] array = s.toCharArray();
        int length = s.length();
        int left = 0;
        int[] table = new int[26];
        for(int right = 0; right < length ;right++){
            int index = array[right] - 'A';
            table[index]++;
            max = Math.max(max,table[index]);
            System.out.println("max = " + max);
            if(right - left + 1 > max + k){
                table[ array[left] - 'A' ] --;
                left++;
            }
        }
        return length - left;
    }


















        public static int f(String s, int k){
        int right = 0, left = 0, res = 0,output = 0;
        int[] table = new int[26];
        Arrays.fill(table,0);
        char[] ch = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (; right < ch.length; right++) {
            int index = ch[right] - 'A';
            table[index]++;
            res = Math.max(res, table[index]);
            if(right - left +1 -k > res){
                table[ch[left]-'A']--;
                left++;
            } else {
                output  = Math.max(output,right-left+1);
            }

        }
        return res;
    }
}
