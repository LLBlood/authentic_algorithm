package cn.liulin.algorithm.leetcode.string.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * cn.liulin.algorithm.leetcode.string.simple$
 * 3. 无重复字符的最长子串
 * @author ll
 * @date 2022-06-27 10:14:26
 **/
public class LongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        int start = 0;
        int end = 0;
        int maxL = 0;
        char[] chars = s.toCharArray();
        while (end < chars.length) {
            char aChar = chars[end];
            if (map.containsKey(aChar)) {
                int index = map.get(aChar);
                maxL = Math.max(maxL, end - start);
                start = Math.max(start, index + 1);
            }
            map.put(aChar, end);
            end++;
        }
        return Math.max(maxL, end - start);
    }

    public static void main(String[] args) {
        String s = "abba";
        new LongestSubstring3().lengthOfLongestSubstring(s);
    }

    public int lengthOfLongestSubstring3(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
