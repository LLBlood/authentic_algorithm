package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 806. 写字符串需要的行数
 * @author ll
 * @date 2021-10-21 13:36:20
 **/
public class NumberLineOfWriteStr806 {
    /**
     * 自定义：顺序遍历
     * @author ll
     * @date 2021-10-21 13:46:36
     * @param widths
     * @param s
     * @return int[]
     **/
    public int[] numberOfLines(int[] widths, String s) {
        int line = 1;
        int lineSum = 0;
        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            if (lineSum + width > 100) {
                line += 1;
                lineSum = width;
            } else {
                lineSum += width;
            }
        }
        return new int[] {line, lineSum};
    }
}
