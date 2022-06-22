package cn.liulin.algorithm.leetcode.algorithm.simple;

/**
 * cn.liulin.algorithm.leetcode.algorithm.simple$
 *
 * @author ll
 * @date 2022-06-22 18:08:56
 **/
public class FirstWrongVersion278 extends VersionControl {
    public int firstBadVersion(int n) {
        int x = 0;
        int y = n;
        int start = -1;
        while (x <= y) {
            int mid = (x + y) >> 1;
            if (isBadVersion(mid)) {
                start = mid;
                y = mid - 1;
            } else {
                x = mid + 1;
            }
        }
        return start;
    }
}
