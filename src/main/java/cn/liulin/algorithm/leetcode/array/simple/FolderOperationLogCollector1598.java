package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1598. 文件夹操作日志搜集器
 * @author ll
 * @date 2022-01-24 09:53:38
 **/
public class FolderOperationLogCollector1598 {
    public int minOperations(String[] logs) {
        int count = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                count = Math.max(count - 1, 0);
            } else if (!log.equals("./")) {
                count++;
            }
        }
        return count;
    }
}
