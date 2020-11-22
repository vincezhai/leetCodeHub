package com.zwx.leetcode.bfs_dfs.island;

import com.zwx.learn.array.Array;

import java.util.Arrays;

public class L_M_695 {
    public static void main(String[] args) {
        int[][] a = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,1},
                {1,1,1,0}
        };
        int res = maxAreaOfIsland(a);
        System.out.println("res = " + res);
        for (int i = 0; i < a.length ; i++) {
            System.out.println( Arrays.toString(a[i]) );
        }
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int row =grid.length;
        int col = grid[0].length;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1){
                    //int[] a = {0};
                    System.out.println( dfs(i,j,row,col,grid));
                    max = Math.max(max,dfs(i,j,row,col,grid));
                }
            }
        }
        return max;
    }

    public static int dfs(int i, int j, int row, int col, int[][] grid ) {
        if( (i<0 || i>=row) || (j<0 || j>=col) ){
           return 0;
        }
        if(grid[i][j] == 0){
            return 0;
        }
        int count = 1;
        grid[i][j] = 0;
        count += dfs(i,j+1,row,col,grid);
        count += dfs(i,j-1,row,col,grid);
        count += dfs(i+1,j,row,col,grid);
        count += dfs(i-1,j,row,col,grid);
        return count;
    }
}
