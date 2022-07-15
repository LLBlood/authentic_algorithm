package cn.liulin.algorithm.leetcode.string.simple;

import com.sun.xml.internal.ws.api.ha.HaInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.string.simple$
 * 409. 最长回文串
 * @author ll
 * @date 2022-07-15 18:15:00
 **/
public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int sum = 0;
        boolean ji = true;
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            Integer value = characterIntegerEntry.getValue();
            if (value % 2 == 0) {
                sum += value;
            } else {
                if (ji) {
                    sum += value;
                    ji = false;
                } else {
                    sum += value - 1;
                }
            }
        }
        return sum;
    }

    public int longestPalindrome2(String s) {
        // 找出可以构成最长回文串的长度
        int[] arr = new int[128];
        for(char c : s.toCharArray()) {
            arr[c]++;
        }
        int count = 0;
        for (int i : arr) {
            count += (i % 2);
        }
        return count == 0 ? s.length() : (s.length() - count + 1);
    }

    public int longestPalindrome3(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
