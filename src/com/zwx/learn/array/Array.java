package com.zwx.learn.array;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        // quick show
        System.out.println(Arrays.toString(arr));
        int newAdd = 4;

        //add
        int[] newarray = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            newarray[i] = arr[i];
        }
        newarray[arr.length] = newAdd;
        arr = newarray;
        System.out.println(Arrays.toString(arr));

        //delete
        int[] arr1 = new int[] {1,2,3,4};
        int[] newarr1 = new int[arr.length-1];
        int idx = 0;

        for (int i = 0; i < newarr1.length; i++) {
            if(i<idx){
                newarr1[i] = arr1[i];
            }else {
                newarr1[i] = arr1[i+1];
            }
        }
        arr1 = newarr1;
        System.out.println(Arrays.toString(arr1));


    }
}
