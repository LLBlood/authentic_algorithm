package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1232. 缀点成线
 * @author ll
 * @date 2022-11-21 13:31:18
 **/
public class LacingPointFormingLine1323 {
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (A * x + B * y != 0) {
                return false;
            }
        }
        return true;
    }
}
