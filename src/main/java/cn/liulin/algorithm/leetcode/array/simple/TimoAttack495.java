package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 495. 提莫攻击
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 * 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 * @author ll
 * @date 2021-10-12 10:20:44
 **/
public class TimoAttack495 {
    /**
     * 自定义法：单次扫描
     * @author ll
     * @date 2021-10-12 10:30:35
     * @param timeSeries
     * @param duration
     * @return int
     **/
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (duration == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            int diff = timeSeries[i] - timeSeries[i - 1];
            if (diff >= duration) {
                count += duration;
            } else {
                count += diff;
            }
        }
        count += duration;
        return count;
    }
}
