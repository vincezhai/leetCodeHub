//在给定的网格中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。 
//
// 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 输入：[[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 输入：[[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 10 
// 1 <= grid[0].length <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// Related Topics 广度优先搜索 
// 👍 340 👎 0

package leetcode.editor.cn;

import javafx.util.Pair;
import org.omg.CORBA.INTERNAL;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
* Java：腐烂的橘子
* @author zwx
*/
public class RottingOranges{
    public static void main(String[] args) {
        Solution solution = new RottingOranges().new Solution();
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        int res = solution.orangesRotting(grid);
        System.out.println("res = " + res);

        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int row;

        private int col;

        private final int[] X_DIR = {0, 0, 1, -1};

        private final int[] Y_DIR = {1, -1, 0, 0};

        public int orangesRotting(int[][] grid) {
            int res = 0;
            // calc basic
            this.row = grid.length;
            this.col = grid[0].length;
            if(grid == null || row == 0 || col == 0){
                return 0;
            }

            // first detect bad point
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(grid[i][j] == 2){
                        Pair<Integer, Integer> pair = new Pair<>(i, j);
                        queue.offer(pair);
                        map.put(pair, 0);
                    }
                }
            }

            // travel all bad point, update and record step by using hashMap
            while (!queue.isEmpty()){
                Pair<Integer, Integer> currPair = queue.poll();
                int x = currPair.getKey();
                int y = currPair.getValue();

                for (int step = 0; step < 4; step++) {
                    int xCopy = x + X_DIR[step];
                    int yCopy = y + Y_DIR[step];
                    Pair<Integer, Integer> tmpPair = new Pair<>(xCopy, yCopy);

                    if(inGrid(xCopy, yCopy) && grid[xCopy][yCopy] == 1){
                        queue.offer(tmpPair);
                        // key statement
                        res = map.get(currPair) + 1;
                        map.put(tmpPair, res);
                        grid[xCopy][yCopy] = 2;
                    }
                }

            }

            // judge result grid
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col ; j++) {
                    if(grid[i][j] == 1){
                        return -1;
                    }
                }
            }
            return res;
        }

        private boolean inGrid(int x, int y) {
            return (x >= 0 && x < row && y >= 0 && y < col);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}