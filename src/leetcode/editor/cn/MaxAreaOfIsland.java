//给定一个包含了一些 0 和 1 的非空二维数组 grid 。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。) 
//
// 
//
// 示例 1: 
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// [[0,0,0,0,0,0,0,0]] 
//
// 对于上面这个给定的矩阵, 返回 0。 
//
// 
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。 
// Related Topics 深度优先搜索 数组 
// 👍 463 👎 0

package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
* Java：岛屿的最大面积
* @author zwx
*/
public class MaxAreaOfIsland{
    public static void main(String[] args) {
        Solution solution = new MaxAreaOfIsland().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int[] X_DIR = {1, -1, 0, 0};
        private final int[] Y_DIR = {0, 0, 1, -1};

        private int row;

        private int col;

        public int maxAreaOfIsland(int[][] grid) {
            row = grid.length;
            col = grid[0].length;
            // sp
            if(grid == null || row == 0 || col == 0){
                return 0;
            }
            // normal
            int res = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(grid[i][j] == 1){
                        res = Math.max(res, bfs(i, j, grid));
                    }
                }
            }
            return res;
        }

        private int bfs(int i, int j, int[][] grid) {
            // grid[i][j] = 0;
            int num = 1;
            Pair<Integer, Integer> pair = new Pair<>(i, j);
            Queue<Pair> queue = new LinkedList<Pair>();
            queue.offer(pair);

            while (!queue.isEmpty()){
                Pair<Integer, Integer> currPair = queue.poll();
                int x = currPair.getKey();
                int y = currPair.getValue();
                grid[x][y] = 0;

                for (int step = 0; step < 4; step++) {
                    int xCopy = x + X_DIR[step];
                    int yCopy = y + Y_DIR[step];
                    // step in 4 direction
                    if( inGrid(xCopy, yCopy) && grid[xCopy][yCopy] == 1){
                        queue.offer(new Pair(xCopy, yCopy));
                        grid[xCopy][yCopy] = 0;
                        num++;
                    }
                }
            }
            return num;
        }

        private boolean inGrid(int x, int y) {
            return (x >= 0 && x < row && y >= 0 && y < col);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}