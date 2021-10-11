package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 463. 岛屿的周长
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * @author ll
 * @date 2021-10-11 16:47:17
 **/
public class PerimeterOfTheIsland463 {
    /**
     * 自定义法：相邻比减2
     * 两个小岛如果相连，则该小岛的周长会减去2，所以只需要判断一个小岛左上是否存在小岛即可
     * @author ll
     * @date 2021-10-11 17:29:39
     * @param grid
     * @return int
     **/
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    //检查这个小岛左边和上边是否存在小岛，并减去2即可
                    if (i > 0) {
                        //检查上边
                        if (grid[i - 1][j] == 1) {
                            perimeter -= 2;
                        }
                    }
                    if (j > 0) {
                        //检查左边
                        if (grid[i][j - 1] == 1) {
                            perimeter -= 2;
                        }
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int i = new PerimeterOfTheIsland463().islandPerimeter(grid);
        System.out.println(i);
    }
}
