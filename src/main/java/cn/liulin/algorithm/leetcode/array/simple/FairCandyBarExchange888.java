package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 888. 公平的糖果棒交换
 * @author ll
 * @date 2021-10-25 17:06:37
 **/
public class FairCandyBarExchange888 {
    /**
     * 官方：哈希算法
     * @author ll
     * @date 2021-10-25 17:19:41
     * @param aliceSizes
     * @param bobSizes
     * @return int[]
     **/
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumY = Arrays.stream(aliceSizes).sum();
        int sumX = Arrays.stream(bobSizes).sum();
        int diff = (sumX - sumY) >> 1;
        Set<Integer> setBob = new HashSet<>();
        for (int bobSize : bobSizes) {
            setBob.add(bobSize);
        }
        for (int aliceSize : aliceSizes) {
            int i = diff + aliceSize;
            if (setBob.contains(i)) {
                return new int[] {aliceSize, i};
            }
        }
        return null;
    }
}
