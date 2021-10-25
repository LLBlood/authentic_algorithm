package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 892. 三维形体的表面积
 * @author ll
 * @date 2021-10-25 17:25:28
 **/
public class SurfaceAreaOfThreeDimensional892 {
    /**
     * 自定义：数学法
     * @author ll
     * @date 2021-10-25 17:49:52
     * @param grid
     * @return int
     **/
    public int surfaceArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    sum += grid[i][j] * 6 - ((grid[i][j] - 1) * 2);
                }
                if (i > 0) {
                    int min = Math.min(grid[i][j], grid[i - 1][j]);
                    sum -= min * 2;
                }
                if (j > 0) {
                    int min = Math.min(grid[i][j], grid[i][j - 1]);
                    sum -= min * 2;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] area = {{1,0},{0,2}};
        int i = new SurfaceAreaOfThreeDimensional892().surfaceArea(area);
    }
}
