package com.zwx.leetcode.bfs_dfs;

import com.zwx.learn.array.Array;

import java.util.*;

public class L_M_784 {
    public static void main(String[] args) {

        String s = "12a34";
        List<String> res = letterCasePermutation(s);
        for(String str : res){
            System.out.println("str = " + str);
        }
    }

    public static List<String> letterCasePermutation(String s) {
        // pre
        s= s.toLowerCase();
        char[] arr = s.toCharArray();
        int length = s.length();
        // pre for dfs
        List<String> res = new ArrayList<>();
        String path = "";
        dfs(arr, length,res, path,0);
        return res;
    }

    private static void dfs(char[] arr, int length, List<String> res, String path, int pos) {
        if(pos == length){
            res.add(path);
            return;
        }
        // 如果是字母
        if(Character.isLetter(arr[pos]) ){
            String curr = path;
            // one
            path += arr[pos];
            dfs(arr,length,res,path,pos+1);
            //two
            path = curr;
            path += (char)(arr[pos] + ('A' - 'a'));
            dfs(arr,length,res,path,pos+1);
        } else {
            path += arr[pos];
            dfs(arr,length,res,path,pos+1);
        }
    }
}
