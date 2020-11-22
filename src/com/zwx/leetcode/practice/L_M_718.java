package com.zwx.leetcode.practice;

public class L_M_718 {
    public static void main(String[] args) {

    }

    public int findLength(int[] A, int[] B) {
        int max = 0;
        int head1 = 0,tail1 = 0;
        int head2 = 0,tail2 = 0;
        while (tail1 != A.length && tail2 != B.length ){
            int cnt = 0;
            while ( A[head1] == B[head2] && (tail1 != A.length && tail2 != B.length)){
                cnt++;
                head1++;
                head2++;
            }
            max = Math.max(max,cnt);
            head2 ++;
        }
        return 0;
    }
}
