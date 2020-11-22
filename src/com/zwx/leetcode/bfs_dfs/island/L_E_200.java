package com.zwx.leetcode.bfs_dfs.island;

public class L_E_200 {
    public static void main(String[] args) {
        char[][] a = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        int res = numIslands(a);
        System.out.println("res = " + res);
    }

    public static int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid,row,col,i,j,res);
                }
            }
        }
        return res;
    }

    private static void dfs(char[][] grid, int row, int col, int currRow, int currCol, int res) {
        if( currRow < 0 || currCol < 0 || currCol >= col || currRow >= row ){
            return;
        }
        if(grid[currRow][currCol] == '0') {
            return;
        }
        grid[currRow][currCol] = '0';
        dfs(grid,row,col,currRow,currCol+1,res);
        dfs(grid,row,col,currRow,currCol-1,res);
        dfs(grid,row,col,currRow+1,currCol,res);
        dfs(grid,row,col,currRow-1,currCol,res);
    }

}
