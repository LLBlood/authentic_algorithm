package cn.liulin.algorithm.leetcode.array.simple;
/**
 * 944. 删列造序
 * @author ll
 * @date 2021-10-29 09:57:42
 **/
public class DeleteOrder944{
    /**
     * 自定义：贪心
     * @author ll
     * @date 2021-10-29 09:57:02
     * @param strs
     * @return int
     **/
    public int minDeletionSize(String[] strs) {
        int index = 0;
        int count = 0;
        while (index < strs[0].length()) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].charAt(index) > strs[i + 1].charAt(index)) {
                    count++;
                    break;
                }
            }
            index++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] strings = {"cba","daf","ghi"};
        new DeleteOrder944().minDeletionSize(strings);
    }
}
