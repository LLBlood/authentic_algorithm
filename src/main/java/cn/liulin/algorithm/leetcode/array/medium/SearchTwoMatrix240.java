package cn.liulin.algorithm.leetcode.array.medium;

/**
 * cn.liulin.algorithm.leetcode.array.medium$
 * 240. 搜索二维矩阵 II
 * @author ll
 * @date 2022-07-12 10:54:47
 **/
public class SearchTwoMatrix240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 1 && n == 1) {
            return matrix[0][0] == target;
        }
        return findTarget(matrix, m - 1, n - 1, 0, 0, target);
    }

    private boolean findTarget(int[][] matrix, int m, int n, int x, int y, int target) {
        // 找出x对应的数值
        if (y > n || x > m) {
            return false;
        }
        int startY = y;
        int endY = n;
        while (startY <= endY) {
            int midY = startY + (endY - startY) / 2;
            if (matrix[x][midY] == target) {
                return true;
            } else if (matrix[x][midY] > target) {
                endY = midY - 1;
            } else {
                startY = midY + 1;
            }
        }
        int startX = x;
        int endX = m;
        while (startX <= endX) {
            int midX = startX + (endX - startX) / 2;
            if (matrix[midX][y] == target) {
                return true;
            } else if (matrix[midX][y] > target) {
                endX = midX - 1;
            } else {
                startX = midX + 1;
            }
        }
        return findTarget(matrix, endX, endY, x + 1, y + 1, target);
    }

    public static void main(String[] args) {
        int[][] ints = {{1,1}};
        new SearchTwoMatrix240().searchMatrix(ints, 2);
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            }
        }
        return false;
    }

    public boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            }
        }
        return false;
    }

    public boolean searchMatrix5(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int x = m - 1; x >= 0; x--) {
            int y = 0;
            while (y < n) {
                if (matrix[x][y] == target) {
                    return true;
                } else if (matrix[x][y] < target) {
                    y++;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
