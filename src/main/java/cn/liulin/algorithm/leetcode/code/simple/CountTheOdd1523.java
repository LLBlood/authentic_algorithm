package cn.liulin.algorithm.leetcode.code.simple;
/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1523. 在区间范围内统计奇数数目
 * @author ll
 * @date 2022-11-14 13:28:13
 **/
public class CountTheOdd1523 {
    public int countOdds(int low, int high) {
        if (low == high) {
            if (low % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        int count = 0;
        int size = high - low - 1;
        if (low % 2 != 0 && high % 2 != 0) {
            count += 2;
            count += size / 2;
        } else if (low % 2 != 0 || high % 2 != 0) {
            count++;
            count += size / 2;
        } else {
            if (size > 0) {
                count += size / 2 + 1;
            }
        }
        return count;
    }

    public int countOdds2(int low, int high) {
        return ((high + 1) >> 1) - ((low - 1 + 1) >> 1);
    }
}
