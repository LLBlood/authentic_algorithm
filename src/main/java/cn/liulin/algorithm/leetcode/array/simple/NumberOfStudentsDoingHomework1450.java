package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1450. 在既定时间做作业的学生人数
 * @author ll
 * @date 2022-01-17 13:54:30
 **/
public class NumberOfStudentsDoingHomework1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int i = 0;
        int j = startTime.length;
        int count = 0;
        while (i < j) {
            int s = startTime[i];
            int e = endTime[i];
            if (s <= queryTime && e >= queryTime) {
                count++;
            }
            i++;
        }
        return count;
    }
}
