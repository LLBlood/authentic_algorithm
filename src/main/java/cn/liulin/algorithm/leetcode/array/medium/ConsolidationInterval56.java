package cn.liulin.algorithm.leetcode.array.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.medium$
 * 56. 合并区间
 * @author ll
 * @date 2022-07-07 18:20:28
 **/
public class ConsolidationInterval56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new LinkedList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n) {
            int[] start = intervals[i];
            int startValue = start[0];
            int endValue = start[1];
            while (i + 1 < n) {
                int[] temp = intervals[i + 1];
                if (endValue >= temp[0]) {
                    endValue = Math.max(endValue, temp[1]);
                    i++;
                } else {
                    break;
                }
            }
            list.add(new int[] {startValue, endValue});
            i++;
        }
        int[][] result = new int[list.size()][2];
        for (int i1 = 0; i1 < result.length; i1++) {
            result[i1] = list.get(i1);
        }
        return result;
    }

    public int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < L) {
                list.add(new int[] {L ,R});
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], R);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        new ConsolidationInterval56().merge2(arr);
    }
}
