package com.zwx.leetcode.design;

import java.util.*;

public class LRUCache {

    private HashMap<Integer,Integer> map;
    private Stack<Integer> stack;
    private int max;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        stack = new Stack<>();
        max = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            stack.push(key);
            System.out.println("map.get(key) = " + map.get(key));
            System.out.println();
            return map.get(key);
        } else {
            System.out.println("map.get(key) = " + -1);
            System.out.println();
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            stack.push(key);
            return;
        }
        if(map.size() == max){
            Stack<Integer> stackCopy = (Stack<Integer>) stack.clone();
            int tmp = findNoUseKey(stackCopy);
            System.out.println("tmp = " + tmp);
            map.remove(tmp);
        }
        map.put(key,value);
        stack.push(key);
    }

    private Integer findNoUseKey(Stack<Integer> stack) {
        HashMap<Integer,Integer> currMap = new HashMap();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            if(!currMap.containsValue(cur)){
                currMap.put(stack.size(),cur);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry entry : currMap.entrySet()){
            if(map.containsKey(entry.getValue())){
                list.add((Integer) entry.getKey());
            }
        }
        //List<Integer> list = new ArrayList<>(currMap.keySet());
        return currMap.get(Collections.min(list));
    }

    public void sout(){
        System.out.println("map = " + map);
        System.out.println("stack = " + stack);
        System.out.println();
    }

}
