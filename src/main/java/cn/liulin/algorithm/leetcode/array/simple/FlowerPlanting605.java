package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 605. 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数n ，能否在不打破种植规则的情况下种入n朵花？能则返回 true ，不能则返回 false。
 * @author ll
 * @date 2021-10-15 10:57:10
 **/
public class FlowerPlanting605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int tempZero = 0;
        boolean change = false;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                tempZero++;
            } else {
                int tempCount;
                if (change) {
                    tempCount = (tempZero - 1) / 2;
                } else {
                    tempCount = tempZero / 2;
                }
                count += Math.max(0, tempCount);
                tempZero = 0;
                change = true;
            }
        }
        if (tempZero > 0) {
            if (change) {
                count += tempZero / 2;
            } else {
                count += (tempZero + 1) / 2;
            }
        }
        if (count >= n) {
            return true;
        }
        return false;
    }

    /**
     * 管方法：数学题解法
     * @author ll
     * @date 2021-10-15 11:41:54
     * @param flowerbed
     * @param n
     * @return boolean
     **/
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int pre = -1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                if (pre < 0) {
                    count += i / 2;
                } else {
                    count += (i - pre - 2) / 2;
                }
                if (count >= n) {
                    return true;
                }
                pre = i;
            }
        }
        if (pre < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - pre - 1) / 2;
        }
        return count >= n;
    }
}
