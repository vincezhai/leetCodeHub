package com.zwx.learn.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        int target = 6;
        BinarySearch binarySearch = new BinarySearch();
 //       binarySearch.find(2,arr);
        for (int i = 0; i <11 ; i++) {
            binarySearch.find(i+3,arr);
        }
    }

    public void find(int target, int[]arr){
        //binary search
        //必须有序才可以
        int idx = -1;
        int start = 0;
        int end = arr.length-1;
        int mid = (start+end)/2;
        while (true){

           if(start > end){
            //   System.out.println(" no target in array");
               break;
           }

            if(arr[mid] == target){
                idx = mid;
                break;
            }else if(arr[mid] > target){
                end = mid-1;
                mid = (start + end)/2;
            }else if(arr[mid] < target){
                start = mid+1;
                mid = (start + end)/2;
            }
        }

        if(idx!=-1){
            System.out.println("idx = " + idx);
        }else {
            System.out.println(" no such num");
        }

    }
}
