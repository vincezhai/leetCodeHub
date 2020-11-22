package com.zwx.leetcode.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class L_E_136 {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println("f1(nums) = " + f1(nums));
    }

    public static int f1(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            } else {
                map.put(nums[i],1);
            }
        }
        System.out.println("map = " + map);

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            if(2 == (int)entry.getValue() ){
                iterator.remove();
            }
        }
        System.out.println("map = " + map);
        return 0;
    }
}
