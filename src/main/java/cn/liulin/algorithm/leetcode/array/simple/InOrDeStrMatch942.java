package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 942. 增减字符串匹配
 * @author ll
 * @date 2021-10-28 16:02:22
 **/
public class InOrDeStrMatch942 {
    /**
     * 自定义：算法
     * @author ll
     * @date 2021-10-29 09:42:57
     * @param s
     * @return int[]
     **/
    public int[] diStringMatch(String s) {
        int[] arr = new int[s.length() + 1];
        int min = 0;
        int max = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'I') {
                arr[i] = min++;
            } else {
                arr[i] = max--;
            }
        }
        arr[s.length()] = max;
        return arr;
    }
}
