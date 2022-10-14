package cn.liulin.algorithm.leetcode.dynamic.medium;

/**
 * cn.liulin.algorithm.leetcode.dynamic.medium$
 * 1014. 最佳观光组合
 * @author ll
 * @date 2022-10-14 15:16:05
 **/
public class SightseeingCombination1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int zMax = 0;
        for (int i = 1; i < values.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, values[i] + values[j] + j - i);
            }
            zMax = Math.max(zMax, max);
        }
        return zMax;
    }

    public int maxScoreSightseeingPair2(int[] values) {
        int max = 0; int mx = values[0] + 0;
        for (int i = 1; i < values.length; i++) {
            max = Math.max(mx + values[i] - i, max);
            mx = Math.max(mx, values[i] + i);
        }
        return max;
    }
}
