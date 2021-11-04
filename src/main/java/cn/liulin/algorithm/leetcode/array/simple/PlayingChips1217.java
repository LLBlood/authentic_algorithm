package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1217. 玩筹码
 * @author ll
 * @date 2021-11-04 16:49:08
 **/
public class PlayingChips1217 {
    /**
     * 自定义：蠢材暴力法
     * @author ll
     * @date 2021-11-04 17:16:03
     * @param position
     * @return int
     **/
    public int minCostToMoveChips(int[] position) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i : position) {
            if (map.containsKey(i)) {
                min = Math.min(min, map.get(i));
                continue;
            }
            int temp = 0;
            for (int i1 : position) {
                temp += ((Math.abs(i1 - i)) % 2);
            }
            min = Math.min(min, temp);
            map.put(i, temp);
        }
        return min;
    }

    /**
     * 大神解读法
     * 将移动转为奇偶数法
     * 奇数转奇数不要体力，偶数转偶数不要体力，求两者最小值
     * @author ll
     * @date 2021-11-04 17:17:04
     * @param position
     * @return int
     **/
    public int minCostToMoveChips2(int[] position) {
        int odd = 0;
        int even = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                odd++;
            } else {
                even++;
            }
        }
        return odd > even ? even : odd;
    }
}
