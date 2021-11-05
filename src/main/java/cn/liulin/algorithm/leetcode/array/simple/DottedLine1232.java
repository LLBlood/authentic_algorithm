package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1232. 缀点成线
 * @author ll
 * @date 2021-11-04 17:23:26
 **/
public class DottedLine1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) {
            return true;
        }
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            if (x1 == x2) {
                if (x1 != x) {
                    return false;
                }
            } else if (y1 == y2) {
                if (y1 != y) {
                    return false;
                }
            } else {
                if ((x - x1) / (x2 * 1.0 - x1) != (y - y1) / (y2 * 1.0 - y1)) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean checkStraightLine2(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            if ((x - x1) * (y2 - y1) != (y - y1) * (x2 - x1)) {
                return false;
            }
        }
        return true;
    }
}
