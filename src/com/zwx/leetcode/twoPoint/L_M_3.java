package com.zwx.leetcode.twoPoint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class L_M_3 {
    public static void main(String[] args) {
        String s = "puywwkew";
        System.out.println("f1(s) = " + f1(s));
        System.out.println("f2(s) = " + f2(s));

    }

    public static int f1(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                // 不能用 left++，因为可能重复的字符不在left指针的位置，而在 left，right 区间的中间
                //left++;
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }


    public static int f2(String s){
        char[] c = s.toCharArray();
        int right = 0, left = 0, res = 0;
        Set<Character> set = new HashSet<>();
        //set.add(c[0]);
            while(right<s.length())

        {

            if (!set.contains(c[right])) {
                set.add(c[right]);
                right++;
            } else {
                set.remove(c[left]);
                left++;
            }
            res = Math.max(res, right - left);
        }

            return res;
    }


}
