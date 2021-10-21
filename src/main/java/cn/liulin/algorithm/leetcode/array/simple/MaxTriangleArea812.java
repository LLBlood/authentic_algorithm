package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 812. 最大三角形面积
 * 海伦公式
 * p = (a + b + c) / 2
 * S = sqrt(p * (p - a) * (p - b) * (p - c))
 * 鞋带公式
 * S=|(x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1)|/2
 *
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 * @author ll
 * @date 2021-10-21 13:49:31
 **/
public class MaxTriangleArea812{
    /**
     * 暴力法鞋带公式
     * @author ll
     * @date 2021-10-21 14:35:55
     * @param points
     * @return double
     **/
    public double largestTriangleArea(int[][] points) {
        int N = points.length;
        double ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
                }
            }
        }
        return ans;
    }

    private double area(int[] p, int[] q, int[] r) {
        return 0.5 * (Math.abs(p[0]*q[1] + q[0]*r[1] + r[0]*p[1] -
                p[1]*q[0] - q[1]*r[0] - r[1]*p[0]));
    }
}
