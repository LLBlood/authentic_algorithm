package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1779. 找到最近的有相同 X 或 Y 坐标的点
 * @author ll
 * @date 2022-11-16 16:49:16
 **/
public class FindTheNearest1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int index = -1;
        int size = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int i1 = points[i][0];
            int i2 = points[i][1];
            if (i1 == x || i2 == y) {
                int i3 = Math.abs(i1 - x) + Math.abs(i2 - y);
                if (i3 < size) {
                    size = i3;
                    index = i;
                }
            }
        }
        return index;
    }
}
