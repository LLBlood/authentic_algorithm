package cn.liulin.algorithm.leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.medium$
 * 36. 有效的数独
 * @author ll
 * @date 2022-06-12 19:34:15
 **/
public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        List<List<Character>> xList = new ArrayList<>(9);
        List<List<Character>> yList = new ArrayList<>(9);
        List<List<Character>> zList = new ArrayList<>(9);
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            List<Character> xCharacters = new ArrayList<>(9);
            xList.add(xCharacters);
            for (int j = 0; j < n; j++) {
                char value = board[i][j];
                if (xCharacters.contains(value) && value != '.') {
                    return false;
                } else {
                    xCharacters.add(value);
                }
                if (yList.size() <= j) {
                    List<Character> yCharacters = new ArrayList<>(9);
                    yList.add(yCharacters);
                    yCharacters.add(value);
                } else if (yList.get(j).contains(value) && value != '.') {
                    return false;
                }
                yList.get(j).add(value);
                int z = i / 3 * 3 + j / 3;
                if (zList.size() <= z) {
                    List<Character> zCharacters = new ArrayList<>(9);
                    zList.add(zCharacters);
                    zCharacters.add(value);
                } else if (zList.get(z).contains(value) && value != '.') {
                    return false;
                }
                zList.get(z).add(value);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] cahrs = {{'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                    {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                                {'.','.','.','4','1','9','.','.','5'},
                                    {'.','.','.','.','8','.','.','7','9'}};
        boolean validSudoku = new ValidSudoku36().isValidSudoku2(cahrs);
        System.out.println(validSudoku);
    }

    public boolean isValidSudoku2(char[][] board) {
        int[][] xContent = new int[9][9];
        int[][] yContent = new int[9][9];
        int[][][] zContent = new int[3][3][9];
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char value = board[i][j];
                if (value != '.') {
                    int intValue = value - '0' - 1;
                    xContent[i][intValue]++;
                    if (xContent[i][intValue] > 1) {
                        return false;
                    }
                    yContent[intValue][j]++;
                    if (yContent[intValue][j] > 1) {
                        return false;
                    }
                    zContent[i / 3][j / 3][intValue]++;
                    if (zContent[i / 3][j / 3][intValue] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
