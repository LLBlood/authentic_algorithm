package cn.liulin.algorithm.leetcode.array.simple;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 599. 两个列表的最小索引总和
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 * @author ll
 * @date 2021-10-14 10:58:46
 **/
public class MinimumIndexOfList599 {
    public static void main(String[] args) {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Burger King","Tapioca Express","Shogun"};
        String[] restaurant = new MinimumIndexOfList599().findRestaurant(list1, list2);
        System.out.println(JSON.toJSONString(restaurant));
    }

    /**
     * 官方：使用哈希表（线性） [Accepted]
     * @author ll
     * @date 2021-10-14 11:23:34
     * @param list1
     * @param list2
     * @return java.lang.String[]
     **/
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (map.get(list2[i]) + i < min) {
                    list.clear();
                    list.add(list2[i]);
                    min = map.get(list2[i]) + i;
                } else if (map.get(list2[i]) + i == min) {
                    list.add(list2[i]);
                }
            }
        }
        String[] strings = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strings[i] = list.get(i);
        }
        return strings;
    }
}
