package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1351. 统计有序矩阵中的负数
 * @author ll
 * @date 2021-12-06 14:27:40
 **/
public class NegativeNumberInOrder1351 {
    /**
     * 自定义：二分查找法
     * @author ll
     * @date 2021-12-06 17:50:18
     * @param grid
     * @return int
     **/
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mEnd = m - 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = mEnd;
            int pos = -1;
            while (start <= end) {
                int mid = (start + end) >> 1;
                if (grid[i][mid] >= 0) {
                    start = mid + 1;
                } else {
                    pos = mid;
                    end = mid - 1;
                }
            }
            if (pos != -1) {
                mEnd = pos;
                count += (m - pos);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        new NegativeNumberInOrder1351().countNegatives(grid);
    }
}
