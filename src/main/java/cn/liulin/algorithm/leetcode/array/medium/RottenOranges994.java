package cn.liulin.algorithm.leetcode.array.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * cn.liulin.algorithm.leetcode.array.medium$
 * 994. 腐烂的橘子
 * @author ll
 * @date 2022-06-30 15:11:00
 **/
public class RottenOranges994 {
    static int[][] dirts = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] bFlag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                    bFlag[i][j] = true;
                } else if (grid[i][j] == 0) {
                    bFlag[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for (int j = 0; j < size; j++) {
                int[] poll = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int a = poll[0] + dirts[i][0];
                    int b = poll[1] + dirts[i][1];
                    if (a >= 0 && a < m && b >= 0 && b < n && !bFlag[a][b]) {
                        bFlag[a][b] = true;
                        queue.add(new int[]{a, b});
                        flag = true;
                        grid[a][b] = 2;
                    }
                }
            }
            if (flag) {
                sum++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                   return -1;
                }
            }
        }
        return sum;
    }
}
