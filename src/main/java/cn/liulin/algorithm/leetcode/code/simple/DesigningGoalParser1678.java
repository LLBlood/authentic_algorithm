package cn.liulin.algorithm.leetcode.code.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1678. 设计 Goal 解析器
 * @author ll
 * @date 2022-11-22 17:15:32
 **/
public class DesigningGoalParser1678 {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>(3);
        map.put("()", "o");
        map.put("G", "G");
        map.put("(al)", "al");
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            temp.append(command.charAt(i));
            if (map.containsKey(temp.toString())) {
                sb.append(map.get(temp.toString()));
                temp = new StringBuilder();
            }
        }
        return sb.toString();
    }

    public String interpret2(String command) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 1;
        while (start < command.length()) {
            int diff = end - start;
            if (diff == 1) {
                String substring = command.substring(start, end);
                if ("G".equals(substring)) {
                    sb.append("G");
                    start++;
                }
                end++;
            } else if (diff == 2) {
                String substring = command.substring(start, end);
                if ("()".equals(substring)) {
                    sb.append("o");
                    start += 2;
                    end++;
                } else {
                    sb.append("al");
                    start += 4;
                    end += 3;
                }
            }
        }
        return sb.toString();
    }

    public String interpret3(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }

    public String interpret4(String command) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < command.length()) {
            char c = command.charAt(index);
            if ('G' == c) {
                sb.append("G");
            } else {
                index++;
                char c1 = command.charAt(index);
                if (')' == c1) {
                    sb.append("o");
                } else {
                    index += 2;
                    char c2 = command.charAt(index);
                    if (')' == c2) {
                        sb.append("al");
                    }
                }
            }
            index++;
        }
        return sb.toString();
    }
}
