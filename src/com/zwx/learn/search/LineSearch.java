package com.zwx.learn.search;

public class LineSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int target = 8;
        int idx = -1;

        //line search
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] == target){
                idx = i;
                break;
            }
        }
        System.out.println("idx = " + idx);
    }

}
