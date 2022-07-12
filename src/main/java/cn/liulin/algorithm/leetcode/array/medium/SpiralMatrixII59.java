package cn.liulin.algorithm.leetcode.array.medium;

import com.alibaba.fastjson.JSON;

/**
 * cn.liulin.algorithm.leetcode.array.medium$
 * 59. 螺旋矩阵 II
 * @author ll
 * @date 2022-07-11 16:25:48
 **/
public class SpiralMatrixII59 {
    public int[][] generateMatrix(int n) {
        int value = 1;
        int sum = n * n;
        int x = 0;
        int y = 0;
        int[][] ints = new int[n][n];
        while (value <= sum) {
            while (y < n && value <= sum) {
                ints[x][y] = value;
                value++;
                if (y + 1 == n || ints[x][y + 1] != 0) {
                    x++;
                    break;
                } else {
                    y++;
                }
            }
            while (x < n && value <= sum) {
                ints[x][y] = value;
                value++;
                if (x + 1 == n || ints[x + 1][y] != 0) {
                    y--;
                    break;
                } else {
                    x++;
                }
            }
            while (y >= 0 && value <= sum) {
                ints[x][y] = value;
                value++;
                if (y - 1 < 0 || ints[x][y - 1] != 0) {
                    x--;
                    break;
                } else {
                    y--;
                }
            }
            while (x >= 0 && value <= sum) {
                ints[x][y] = value;
                value++;
                if (x - 1 < 0 || ints[x - 1][y] != 0) {
                    y++;
                    break;
                } else {
                    x--;
                }
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        int[][] ints = new SpiralMatrixII59().generateMatrix(1);
        System.out.println(JSON.toJSONString(ints));
    }
}
