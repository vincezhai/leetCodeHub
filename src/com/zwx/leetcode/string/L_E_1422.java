package com.zwx.leetcode.string;

import com.zwx.learn.array.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class L_E_1422 {
    public static void main(String[] args) {
        String s = "1111";
        System.out.println("f1(s) = " + f1(s));
        System.out.println("f2(s) = " + f2(s));
    }

    public static int f3(String s) {
        int max = 0;

        return max;
    }


    // too slow
    public static int f2(String s){
        int length = s.length();
        int max = 0;

        for (int i = 1; i < length; i++) {
            String front = s.substring(0, i);
            String back = s.substring(i, length);
            List<String> left = Arrays.asList(front.split(""));
            List<String> right = Arrays.asList(back.split(""));
            int l = left.stream().filter(s1 -> s1.equals("0")).collect(Collectors.toList()).size();
            int r = right.stream().filter(s1 -> s1.equals("1")).collect(Collectors.toList()).size();
            max = max < l+r ? l+r : max;
        }
        return (int) max;
    }

    public static int f1(String s){
        int length = s.length();
        int max = 0;
        for (int i = 1; i < length; i++) {
            String front = s.substring(0, i);
            String back = s.substring(i, length);
            int frontsize = front.length();
            int backsize = back.length();
            int left = 0;
            int right = 0;
            for (int j = 0; j < s.length(); j++) {
                if(j< frontsize)
                    if (front.charAt(j) == '0')
                        left++;
                if(j<backsize)
                    if (back.charAt(j) == '1')
                        right++;
            }
            max = max < right + left ? right +left : max;
        }
        return max;
    }
}
