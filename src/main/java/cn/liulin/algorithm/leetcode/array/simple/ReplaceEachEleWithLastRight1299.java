package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1299. 将每个元素替换为右侧最大元素
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * 完成所有替换操作后，请你返回这个数组。
 * @author ll
 * @date 2021-11-12 11:32:17
 **/
public class ReplaceEachEleWithLastRight1299 {
    /**
     * 逆序遍历
     * @author ll
     * @date 2021-11-12 13:23:49
     * @param arr
     * @return int[]
     **/
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        ans[n - 1] = -1;
        for (int i = (n - 2); i >= 0; i--) {
            ans[i] = Math.max(ans[i + 1], arr[i + 1]);
        }
        return ans;
    }
}
