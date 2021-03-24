//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 1021 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
* Java：岛屿数量
* @author zwx
*/
public class NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        // TO TEST

        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

        //char[][] grid = {{'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},{'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},{'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},{'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},{'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},{'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};

        int res = solution.numIslands(grid);
        System.out.println("res = " + res);

    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int res = 0;
            int row = grid.length;
            int col = grid[0].length;
            if( grid.length == 0 ){
                return res;
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(grid[i][j] == '1'){
                        bfs(grid, i, j, row, col);
                        res++;
                    }
                }
            }
            return res;
        }

        private void bfs(char[][] grid, int i, int j, int row, int col) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {i,j});

            while (!queue.isEmpty()){
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    int[] tmp = queue.poll();
                    int x = tmp[0];
                    int y = tmp[1];
                    grid[x][y] = '0';

                    if( inGrid(x + 1, y, row, col) && grid[x+1][y] == '1' ){
                        queue.offer(new int[] { x + 1,y});
                        grid[x+1][y] = '0'; // 不可注释，否则会增加工作量，超时
                    }
                    if( inGrid(x-1, y, row, col) && grid[x-1][y] == '1' ){
                        queue.offer(new int[] { x-1,y});
                        grid[x-1][y] = '0';
                    }
                    if( inGrid(x, y+1, row, col) && grid[x][y+1] == '1' ){
                        queue.offer(new int[] { x,y+1});
                        grid[x][y+1] = '0';
                    }
                    if( inGrid(x, y-1, row, col) && grid[x][y-1] == '1' ){
                        queue.offer(new int[] { x,y-1});
                        grid[x][y-1] = '0';
                    }
                }
            }
        }
        public boolean inGrid(int x, int y, int row, int col) {
            return (x >= 0 && x < row && y >= 0 && y < col );
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}