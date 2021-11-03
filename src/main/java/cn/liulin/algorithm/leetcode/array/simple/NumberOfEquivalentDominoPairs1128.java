package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1128. 等价多米诺骨牌对的数量
 * @author ll
 * @date 2021-11-02 13:26:05
 **/
public class NumberOfEquivalentDominoPairs1128 {
    /**
     * 二元组表示 + 计数
     * @author ll
     * @date 2021-11-03 15:31:55 
     * @param dominoes
     * @return int
     **/
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] arr = new int[101];
        int count = 0;
        for (int[] it : dominoes) {
            int sum = it[0] < it[1] ? it[0] * 10 + it[1] : it[1] * 10 + it[0];
            count += arr[sum];
            arr[sum]++;
        }
        return count;
    }
}
