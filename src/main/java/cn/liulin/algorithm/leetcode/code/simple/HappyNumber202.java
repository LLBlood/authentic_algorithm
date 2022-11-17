package cn.liulin.algorithm.leetcode.code.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 202. 快乐数
 * @author ll
 * @date 2022-11-17 16:42:38
 **/
public class HappyNumber202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            int sum = 0;
            while (n > 0) {
                int z = n % 10;
                n /= 10;
                sum += z * z;
            }
            n = sum;
            if (n == 1) {
                return true;
            } else if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
    }

    public boolean isHappy2(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int z = n % 10;
            n /= 10;
            sum += z * z;
        }
        return sum;
    }
}
