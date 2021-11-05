package cn.liulin.algorithm.leetcode.array.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1260. 二维网格迁移
 * @author ll
 * @date 2021-11-05 11:11:33
 **/
public class MeshMigration1260 {
    /**
     * 自定义：取模
     * @author ll
     * @date 2021-11-05 13:27:55
     * @param grid
     * @param k
     * @return java.util.List<java.util.List<java.lang.Integer>>
     **/
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> list = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            List<Integer> temp = new ArrayList<>(n);
            for (int i1 = 0; i1 < n; i1++) {
                temp.add(0);
            }
            list.add(temp);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = i * n + j + k;
                // sum / n 可以算出有多少行，对m取模可以得到真正的行数
                int z = (sum / n) % m;
                // sum % n可以得到真正的列数
                int i1 = sum % n;
                list.get(z).set(i1, grid[i][j]);
            }
        }
        return list;
    }
}
