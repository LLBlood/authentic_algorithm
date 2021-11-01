package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 999. 可以被一步捕获的棋子数
 * @author ll
 * @date 2021-11-01 09:35:35
 **/
public class NumOfPieceCapturedOneStep999 {
    /**
     * 自定义：四个while
     * @author ll
     * @date 2021-11-01 09:57:21
     * @param board
     * @return int
     **/
    public int numRookCaptures(char[][] board) {
        int rXIndex = 0;
        int rYIndex = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    rXIndex = i;
                    rYIndex = j;
                    break;
                }
            }
        }
        int x1 = rXIndex - 1;
        int x2 = rXIndex + 1;
        int y1 = rYIndex - 1;
        int y2 = rYIndex + 1;
        int count = 0;
        while (x1 >= 0) {
            char c = board[x1][rYIndex];
            if (c == '.') {
                x1--;
                continue;
            } else if (c == 'p') {
                count++;
                break;
            } else {
                break;
            }
        }
        while (x2 < board.length) {
            char c = board[x2][rYIndex];
            if (c == '.') {
                x2++;
                continue;
            } else if (c == 'p') {
                count++;
                break;
            } else {
                break;
            }
        }
        while (y1 >= 0) {
            char c = board[rXIndex][y1];
            if (c == '.') {
                y1--;
                continue;
            } else if (c == 'p') {
                count++;
                break;
            } else {
                break;
            }
        }
        while (y2 < board[0].length) {
            char c = board[rXIndex][y2];
            if (c == '.') {
                y2++;
                continue;
            } else if (c == 'p') {
                count++;
                break;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * 官方：方向数组
     * @author ll
     * @date 2021-11-01 09:57:48
     * @param board
     * @return int
     **/
    public int numRookCaptures2(char[][] board) {
        int rXIndex = 0;
        int rYIndex = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rXIndex = i;
                    rYIndex = j;
                    break;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int step = 1; ; ++step) {
                int tx = rXIndex + step * dx[i];
                int ty = rYIndex + step * dy[i];
                if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') {
                    break;
                }
                if (board[tx][ty] == 'p') {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
