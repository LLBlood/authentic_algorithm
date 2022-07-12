package cn.liulin.algorithm.leetcode.array.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.medium$
 * 435. 无重叠区间
 * @author ll
 * @date 2022-07-12 14:22:29
 **/
public class NonOverlappingInterval435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        int[] pre = null;
        int sum = 0;
        for (int[] interval : intervals) {
            if (pre != null) {
                if (pre[0] == interval[0]) {
                    pre[1] = Math.min(pre[1], interval[1]);
                    sum++;
                } else if (pre[1] > interval[0]) {
                    if (pre[1] > interval[1]) {
                        pre = interval;
                    }
                    sum++;
                } else {
                    pre = interval;
                }
            } else {
                pre = interval;
            }
        }
        return sum;
    }

    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
        new NonOverlappingInterval435().eraseOverlapIntervals(intervals);
    }
}
