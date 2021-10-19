package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 744. 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，
 * 请你寻找在这一有序列表里比目标字母大的最小字母。
 * @author ll
 * @date 2021-10-19 10:41:35
 **/
public class FindSmallThanTarget744 {
    /**
     * 二分查找法
     * @author ll
     * @date 2021-10-19 11:22:21
     * @param letters
     * @param target
     * @return char
     **/
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (letters[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }

    public static void main(String[] args) {
        char[] letters = {'e','e','e','e','e','e','n','n','n','n'};
        System.out.println(new FindSmallThanTarget744().nextGreatestLetter(letters, 'e'));
    }
}
