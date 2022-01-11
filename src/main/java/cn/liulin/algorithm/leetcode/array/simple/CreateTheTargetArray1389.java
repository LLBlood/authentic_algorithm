package cn.liulin.algorithm.leetcode.array.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1389. 按既定顺序创建目标数组
 * @author ll
 * @date 2022-01-11 17:15:37
 **/
public class CreateTheTargetArray1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>(index.length);
        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] ints = list.stream().mapToInt(Integer::valueOf).toArray();
        return ints;
    }
}
