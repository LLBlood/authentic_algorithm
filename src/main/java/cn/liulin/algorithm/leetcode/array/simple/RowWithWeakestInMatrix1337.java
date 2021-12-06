package cn.liulin.algorithm.leetcode.array.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1337. 矩阵中战斗力最弱的 K 行
 *
 * @author ll
 * @date 2021-12-03 16:02:20
 **/
public class RowWithWeakestInMatrix1337 {
    /**
     * 官方：二分查找法+堆
     * @author ll
     * @date 2021-12-06 11:09:26
     * @param mat
     * @param k
     * @return int[]
     **/
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        List<int[]> power = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] matILength = mat[i];
            int start = 0;
            int end = m - 1;
            int pos = -1;
            while (start <= end) {
                int mid = (start + end) >> 1;
                if (matILength[mid] == 0) {
                    end = mid - 1;
                } else {
                    pos = mid;
                    start = mid + 1;
                }
            }
            power.add(new int[] {pos + 1, i});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((pair1, pair2) -> {
            if (pair1[0] != pair2[0]) {
                return pair1[0] - pair2[0];
            } else {
                return pair1[1] - pair2[1];
            }
        });
        for (int[] pair : power) {
            pq.offer(pair);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = pq.poll()[1];
        }
        return ans;
    }
}
