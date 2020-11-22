package com.zwx.leetcode.bfs_dfs.island;

public class L_M_994 {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int res = orangesRotting(grid);
        System.out.println("res = " + res);

    }

    public static int orangesRotting(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if( grid[i][j] == 2){
                    int[] time = {0};
                    dfs(grid,i,j,time);
                    max = Math.max(max,time[0]);
                }
            }
        }
        // 遍历后的健康水果数
        int good = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if( grid[i][j] == 1){
                    good++;
                }
            }
        }
        if(good > 0){
            return -1;
        }
        return max;
    }

    private static void dfs(int[][] grid, int row, int col, int[] time) {
        if( row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1){
            return;
        }
        grid[row][col] = 0;
        time[0]++;
        dfs(grid, row+1, col, time);
        dfs(grid, row-1, col, time);
        dfs(grid, row, col+1, time);
        dfs(grid, row, col-1, time);
    }



}
