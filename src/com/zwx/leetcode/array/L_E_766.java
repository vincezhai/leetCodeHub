package com.zwx.leetcode.array;

import com.zwx.learn.array.Array;

import java.util.Arrays;

public class L_E_766 {
    public static void main(String[] args) {
       // int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        int[][] matrix = {{39,39}};
        System.out.println("f1(matrix) = " + f1(matrix));

    }

    public static boolean f1(int[][] matrix){

        boolean res = true;
        String[] array0 = new String[matrix[0].length];
        String[] array1 = new String[matrix.length];
        Arrays.fill(array0,"");
        Arrays.fill(array1,"");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i <= j){
                    array0[j-i] += String.valueOf(matrix[i][j]) + " ";
                    System.out.println("array0[" +(j-i) +"}: " + array0[j - i]);
                }else {
                    array1[i-j] += String.valueOf(matrix[i][j]) + " ";
                    System.out.println("array1[" +(i-j) +"}: " + array0[i - j]);
                }
            }
        }
        for(String str : array0){
            String[] array = str.trim().split(" ");
            if(!allSame(array))
                return false;
            System.out.println("str0 = " + str);
        }
        for(String str : array1){
            String[] array = str.trim().split(" ");
            if(!allSame(array))
                return false;
            System.out.println("str1 = " + str);
        }
        return res;
    }

    public static boolean allSame(String[] s){
        boolean res = true;
        for (int i = 0; i < s.length -1; i++) {
            if ( !s[i].equals(s[i+1]) ){
                res = false;
            }
        }
        return res;
    }
}

/*
00 01 02 03
10 11 12 13
20 21 22 23
30 31 32 33



 */
