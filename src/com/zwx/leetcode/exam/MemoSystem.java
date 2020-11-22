package com.zwx.leetcode.exam;

import java.util.*;

public class MemoSystem {
    private HashMap<Integer, List<String[]>> map;

    MemoSystem(){
        map = new HashMap<>();
    }

    public int addEvent(int startDate, String content, int num, int period){
        int res = 0;
        for (int i = 0; i < num; i++,startDate+=period) {
            List<String[]> list = new ArrayList<>();
            String[] event = new String[2];
            event[0] = content;
            event[1] = "0";
            if(map.containsKey(startDate)){
                List<String[]> currList =  map.get(startDate);
                int length = currList.size();
                boolean hasEvent = false;
                for(int j = 0; j< length; j++){
                    String[] strs = currList.get(j);
                    if(content.equals( strs[0] )){
                        hasEvent = true;
                    }
                }
                if(!hasEvent){
                    currList.add(event);
                    res++;
                }
            } else {
                list.add(event);
                map.put(startDate,list);
                res++;
            }
        }
        return res;
    }

    public boolean finishEvent(int date, String content){
        if(!map.containsKey(date)){
            return false;
        }
        List<String[]> currList = map.get(date);
        for(int i = 0 ; i< currList.size(); i++){
            String[] strs = currList.get(i);
            if(content.equals( strs[0] )){
                if("0".equals(strs[1])){
                    String[] tmp = strs;
                    tmp[1] = "1";
                    currList.set(i,tmp);
                } else {
                    return false;
                }
            }
        }
            return true;
    }

    public boolean removeEvent(int date, String content){
        if(!map.containsKey(date)){
            return false;
        }
        List<String[]> currList = map.get(date);
        for(int i = 0 ; i< currList.size(); i++){
            String[] strs = currList.get(i);
            if(content.equals( strs[0])){
                currList.remove(i);
                return true;
            }
        }
        return false;
    }

    public String[] queryTodo(int startDate, int endDate){

        List<String> list = new ArrayList<>();
        for (int i = startDate; i <= endDate ; i++) {
            List<String> listmp = new ArrayList<>();
            if(map.containsKey(i)){
                List<String[]> currList = map.get(i);
                for(String[] strs : currList){
                    if("0".equals(strs[1])){
                        listmp.add(strs[0]);
                    }
                }
                Collections.sort(listmp);
            }
            list.addAll(listmp);
        }

        String[] res = new String[list.size()];
        for (int i = 0; i <res.length ; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void getMap() {
        System.out.println("============= MAP ======================");
        for(Map.Entry entry : this.map.entrySet()){
            int data = (int)entry.getKey();
            System.out.println("data = " + data);

            List<String[]> event = (List<String[]>) entry.getValue();
            for(String[] strs : event){
                List<String> list = Arrays.asList(strs);
                System.out.println("event = " + list);
            }
        }
        System.out.println("=============== END ====================");
        for (int i = 0; i < 3 ; i++) {
            System.out.println();
        }
    }
}
