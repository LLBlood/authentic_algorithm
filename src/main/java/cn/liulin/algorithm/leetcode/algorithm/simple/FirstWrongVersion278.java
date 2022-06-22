package cn.liulin.algorithm.leetcode.algorithm.simple;

/**
 * cn.liulin.algorithm.leetcode.algorithm.simple$
 * 278. 第一个错误的版本
 * @author ll
 * @date 2022-06-22 18:08:56
 **/
public class FirstWrongVersion278 extends VersionControl {
    public int firstBadVersion(int n) {
        int x = 1;
        int y = n;
        while (x < y) {
            int mid = x + (y - x) / 2;
            if (isBadVersion(mid)) {
                y = mid;
            } else {
                x = mid + 1;
            }
        }
        return x;
    }
}
