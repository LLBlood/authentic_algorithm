package cn.liulin.algorithm.leetcode.array.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * cn.liulin.algorithm.leetcode.array.medium$
 * 542. 01 矩阵
 * @author ll
 * @date 2022-06-30 09:38:56
 **/
public class Matrix542 {
    public int[][] updateMatrix(int[][] mat) {
        List<int[]> list = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    list.add(new int[] {i, j});
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = getMin(i, j, list);
                }
            }
        }
        return mat;
    }

    private int getMin(int i, int j, List<int[]> list) {
        int[] ints = list.get(0);
        int min = Math.abs(ints[0] - i) + Math.abs(ints[1] - j);
        for (int k = 1; k < list.size(); k++) {
            int[] temp = list.get(i);
            int i1 = Math.abs(temp[0] - i) + Math.abs(temp[1] - j);
            min = Math.min(min, i1);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][] {{0,0,0},{0,1,0},{1,1,1}};
        new Matrix542().updateMatrix(ints);
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] bFlag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                    bFlag[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int a = poll[0] + dirs[i][0];
                int b = poll[1] + dirs[i][1];
                if (a >= 0 && a < m && b >= 0 && b < n && !bFlag[a][b]) {
                    queue.offer(new int[] {a, b});
                    bFlag[a][b] = true;
                    mat[a][b] = mat[poll[0]][poll[1]] + 1;
                }
            }
        }
        return mat;
    }
}
