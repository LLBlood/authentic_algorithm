package cn.liulin.algorithm.leetcode.array.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1656. 设计有序流
 * @author ll
 * @date 2022-02-15 14:42:01
 **/
public class DesignOrderedFlow1656 {
    int ptr = 0;
    String[] strArr = null;

    public DesignOrderedFlow1656(int n) {
        strArr = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        strArr[idKey - 1] = value;
        List<String> list = new ArrayList<>();
        while (ptr < strArr.length && strArr[ptr] != null) {
            list.add(strArr[ptr]);
            ptr++;
        }
        return list;
    }
}
