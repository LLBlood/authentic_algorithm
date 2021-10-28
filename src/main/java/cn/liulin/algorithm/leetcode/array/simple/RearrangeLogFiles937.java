package cn.liulin.algorithm.leetcode.array.simple;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 937. 重新排列日志文件
 * @author ll
 * @date 2021-10-28 11:15:47
 **/
public class RearrangeLogFiles937 {
    /**
     * 自定义：拼凑法
     * @author ll
     * @date 2021-10-28 14:11:36
     * @param logs
     * @return java.lang.String[]
     **/
    public String[] reorderLogFiles(String[] logs) {
        int zmIndex = logs.length - 1;
        for (int i = logs.length - 1; i >= 0; i--) {
            String log = logs[i];
            char c = log.charAt(log.length() - 1);
            if (c <= '9' && c >= '0') {
                String temp = log;
                logs[i] = logs[zmIndex];
                logs[zmIndex] = temp;
                zmIndex--;
            }
        }
        for (int i = 0; i < zmIndex; i++) {
            for (int j = i + 1; j <= zmIndex; j++) {
                String logI = logs[i];
                String logJ = logs[j];
                String[] iArr = logI.split(" ");
                String[] jArr = logJ.split(" ");
                boolean change = false;
                for (int k = 1; k < iArr.length; k++) {
                    if (k == iArr.length) {
                        change = true;
                        break;
                    } else if (k == jArr.length) {
                        logs[i] = logs[j];
                        logs[j] = logI;
                        change = true;
                        break;
                    }
                    if (iArr[k].compareTo(jArr[k]) > 0) {
                        logs[i] = logs[j];
                        logs[j] = logI;
                        change = true;
                        break;
                    } else if (iArr[k].compareTo(jArr[k]) < 0) {
                        change = true;
                        break;
                    }
                }
                if (!change) {
                    if (iArr[0].compareTo(jArr[0]) > 0) {
                        logs[i] = logs[j];
                        logs[j] = logI;
                        break;
                    }
                }
            }
        }
        return logs;
    }

    /**
     * 自定义排序
     * @author ll
     * @date 2021-10-28 14:48:41
     * @param logs
     * @return java.lang.String[]
     **/
    public String[] reorderLogFiles2(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean digit1 = Character.isDigit(split1[1].charAt(0));
            boolean digit2 = Character.isDigit(split2[1].charAt(0));
            if (!digit1 && !digit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) {
                    return cmp;
                }
                return split1[0].compareTo(split2[0]);
            }
            return digit1 ? (digit2 ? 0 : 1) : -1;
        });
        return logs;
    }

    public static void main(String[] args) {
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        new RearrangeLogFiles937().reorderLogFiles(logs);
        System.out.println("act".compareTo("off"));
        System.out.println(JSON.toJSONString("a1 9 2 3 1".split(" ", 2)));
    }
}
