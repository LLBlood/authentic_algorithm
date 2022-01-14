package cn.liulin.algorithm.leetcode.array.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1431. 拥有最多糖果的孩子
 * @author ll
 * @date 2022-01-14 14:19:58
 **/
public class ChildrenWithTheMostCandy1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>(candies.length);
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        for (int i = 0; i < candies.length; i++) {
            list.add(max - candies[i] <= extraCandies);
        }
        return list;
    }
}
