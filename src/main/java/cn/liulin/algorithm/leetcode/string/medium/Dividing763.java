package cn.liulin.algorithm.leetcode.string.medium;

import java.util.*;

/**
 * cn.liulin.algorithm.leetcode.string.medium$
 * 763. 划分字母区间
 * @author ll
 * @date 2022-07-19 16:23:11
 **/
public class Dividing763 {
    public List<Integer> partitionLabels(String s) {
        if (s.length() == 1) {
            return Collections.singletonList(1);
        }
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int[] ints = map.get(c);
                ints[1] = i;
            } else {
                int[] ints = new int[2];
                ints[0] = i;
                ints[1] = i;
                map.put(c, ints);
            }
        }
        List<Integer> list = new LinkedList<>();
        int[] ints1 = map.get(s.charAt(0));
        int start = ints1[0];
        int end = ints1[1];
        list.add(end - start + 1);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int[] ints = map.get(c);
            if (ints[0] < end) {
                if (ints[1] > end) {
                    list.set(list.size() - 1, list.get(list.size() - 1) + ints[1] - end);
                    end = ints[1];
                }
            } else {
                start = ints[0];
                end = ints[1];
                list.add(end - start + 1);
            }
        }
        return list;
    }

    public List<Integer> partitionLabels2(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] = i;
        }
        List<Integer> list = new LinkedList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, arr[s.charAt(i) - 'a']);
            if (i == end) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new Dividing763().partitionLabels("ababcbacadefegdehijhklij");
    }
}
