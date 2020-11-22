package com.zwx.leetcode.bfs_dfs;

import org.omg.CORBA.INTERNAL;

import java.util.*;

// notCorrect
public class L_M_207 {
    public static void main(String[] args) {
        int a = 8;
        int[][] arr = {
                {1,0},
                {2,6},
                {1,7},
                {6,4},
                {7,0},
                {0,5}
        };
        System.out.println(canFinish(a, arr));
    }

    public static  boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0){
            return true;
        }
        // hashMap
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if(map.containsKey(prerequisites[i][0])){
                List<Integer> tmpList = map.get(prerequisites[i][0]);
                tmpList.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], tmpList);
            }else {
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], tmpList);
            }
        }
        // 课程遍历
        for (int i = 0; i < numCourses; i++) {
            List<Integer> hasShow = new ArrayList<>();
            if( !canFinishForOne(map,i,hasShow) ){
                return false;
            }
        }
        return true;
    }

    public static boolean canFinishForOne(HashMap<Integer, List<Integer>> map, int courseId, List<Integer> hasShow){
        if(!map.containsKey(courseId)){
            return true;
        }
        if(hasShow.contains(courseId)){
            return false;
        }
        hasShow.add(courseId);
        List<Integer> children = map.get(courseId);
        if(children != null){
            for(Integer child : children){
                if(canFinishForOne(map,child,hasShow) == false){
                    return false;
                }
            }
        }
        return true;
    }

}
