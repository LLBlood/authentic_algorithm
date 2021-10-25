package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 883. 三维形体投影面积
 * @author ll
 * @date 2021-10-25 16:39:38
 **/
public class ProjectedAreaOfThreeDimensional883 {
    /**
     * 自定义： 数学
     * @author ll
     * @date 2021-10-25 17:05:13
     * @param grid
     * @return int
     **/
    public int projectionArea(int[][] grid) {
        int N = grid.length;
        int xArea = 0;
        for (int i = 0; i < N; i++) {
            int gIMax = 0;
            int gJMax = 0;
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 0) {
                    xArea += 1;
                }
                gIMax = Math.max(grid[i][j], gIMax);
                gJMax = Math.max(grid[j][i], gJMax);
            }
            xArea += gIMax + gJMax;
        }
        return xArea;
    }
}
