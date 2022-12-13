package cn.liulin.algorithm.leetcode.code.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.code.medium$
 * 54. 螺旋矩阵
 * @author ll
 * @date 2022-12-13 15:35:29
 **/
public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int sum = matrix.length * matrix[0].length;
        List<Integer> list = new LinkedList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        int mIndex = 0;
        int nIndex = 0;
        while (list.size() < sum) {
            while (nIndex <= right && list.size() < sum) {
                list.add(matrix[mIndex][nIndex]);
                nIndex++;
            }
            nIndex--;
            right--;
            mIndex++;
            while (mIndex <= down && list.size() < sum) {
                list.add(matrix[mIndex][nIndex]);
                mIndex++;
            }
            mIndex--;
            down--;
            nIndex--;
            while (nIndex >= left && list.size() < sum) {
                list.add(matrix[mIndex][nIndex]);
                nIndex--;
            }
            nIndex++;
            left++;
            mIndex--;
            while (mIndex > up && list.size() < sum) {
                list.add(matrix[mIndex][nIndex]);
                mIndex--;
            }
            mIndex++;
            up++;
            nIndex++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> integers = new SpiralMatrix54().spiralOrder(arr);
        System.out.println(integers);
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }
}
