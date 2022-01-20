package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1566. 重复至少 K 次且长度为 M 的模式
 * @author ll
 * @date 2022-01-20 14:19:58
 **/
public class RepeatThePatternWithLength1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        for (int l = 0; l <= n - m * k; ++l) {
            int offset;
            for (offset = 0; offset < m * k; ++offset) {
                if (arr[l + offset] != arr[l + offset % m]) {
                    break;
                }
            }
            if (offset == m * k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,3};
        int m = 2;
        int k = 3;
        boolean b = new RepeatThePatternWithLength1566().containsPattern(arr, m, k);
        System.out.println(b);
    }
}
