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
        int[][] ints = new SpiralMatrixII59().generateMatrix3(1);
        System.out.println(JSON.toJSONString(ints));
    }

    public int[][] generateMatrix2(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }

    public int[][] generateMatrix3(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }
}
