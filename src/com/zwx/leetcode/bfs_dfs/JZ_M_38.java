package com.zwx.leetcode.bfs_dfs;

import com.zwx.learn.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JZ_M_38 {
    public static void main(String[] args) {
        String s = "abb";
        String[] ss = permutation(s);
        for(String str : ss)
            System.out.println("str = " + str);
        System.out.println("ss.length = " + ss.length);
    }
    public static String[] permutation(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        List<String> res = new ArrayList();
        String path = "";
        boolean[] used = new boolean[array.length];
        dfs(array,res,path,used);
        String[] strs = new String[res.size()];
        for(int i = 0; i < strs.length ;i++){
            strs[i] = res.get(i);
        }
        return strs;
    }

    private static void dfs(char[] array, List<String> res, String path, boolean[] used) {
        if(path.length() == array.length){
            res.add(path);
        }
        for (int i = 0; i < array.length; i++) {
            if(i>0 && (array[i] == array[i-1]) && !used[i-1]){
                continue;
            }
            if(!used[i]){
                path+=array[i];
                used[i] = true;
                dfs(array,res,path,used);
                used[i] = false;
                path = path.substring(0,path.length()-1);
            }
        }
    }


}
