package com.zwx.leetcode.bfs_dfs.island;

public class L_E_463 {
    public static void main(String[] args) {
        int[][] a = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        int res = islandPerimeter(a);
        System.out.println("res = " + res);
    }

    public static int islandPerimeter(int[][] grid) {
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1){
                    res += calcu(i,j+1,row,col,grid,res);
                    res += calcu(i,j-1,row,col,grid,res);
                    res += calcu(i+1,j,row,col,grid,res);
                    res += calcu(i-1,j,row,col,grid,res);
                }
            }
        }
        return res;
    }

    public static int calcu(int i, int j, int row, int col,int[][] grid,int res) {
        if( ( i<0||i>=row ) || ( j<0|| j>=col ) || (grid[i][j] == 0) ){
            return 1;
        } else {
            return 0;
        }
    }
}
