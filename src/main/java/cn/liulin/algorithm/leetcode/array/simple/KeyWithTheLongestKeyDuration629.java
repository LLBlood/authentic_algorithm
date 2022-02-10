package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1629. 按键持续时间最长的键
 * @author ll
 * @date 2022-02-10 16:55:52
 **/
public class KeyWithTheLongestKeyDuration629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTime = releaseTimes[0];
        char maxKey = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int diff = releaseTimes[i] - releaseTimes[i - 1];
            if (diff > maxTime) {
                maxTime = diff;
                maxKey = keysPressed.charAt(i);
            } else if (diff == maxTime) {
                char c = keysPressed.charAt(i);
                if (c - maxKey > 0) {
                    maxKey = c;
                }
            }
        }
        return maxKey;
    }
}
