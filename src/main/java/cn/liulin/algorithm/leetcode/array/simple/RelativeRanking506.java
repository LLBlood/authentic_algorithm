package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 506. 相对名次
 * 给出N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 * (注：分数越高的选手，排名越靠前。)
 * @author ll
 * @date 2021-10-12 10:50:35
 **/
public class RelativeRanking506 {
    
    /**
     * 自定义法：暴力法
     * @author ll
     * @date 2021-10-12 11:09:22
     * @param score
     * @return java.lang.String[]
     **/
    public String[] findRelativeRanks(int[] score) {
        Integer[] scoreInt = new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            scoreInt[i] = score[i];
        }
        Map<Integer, String> map = new HashMap<>(score.length);
        Arrays.sort(scoreInt, Collections.reverseOrder());
        int challenge = 4;
        for (int i = 0; i < scoreInt.length; i++) {
            switch (i) {
                case 0:
                    map.put(scoreInt[0], "Gold Medal");
                    break;
                case 1:
                    map.put(scoreInt[1], "Silver Medal");
                    break;
                case 2:
                    map.put(scoreInt[2], "Bronze Medal");
                    break;
                default:
                    map.put(scoreInt[i], challenge++ + "");
                    break;
            }

        }
        String[] strings = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            strings[i] = map.get(score[i]);
        }
        return strings;
    }
}
