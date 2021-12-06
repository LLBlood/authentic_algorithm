package cn.liulin.algorithm.leetcode.array.simple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1346. 检查整数及其两倍数是否存在
 * @author ll
 * @date 2021-12-06 13:33:27
 **/
public class CheckIntMultipleExist1346 {
    /**
     * 自定义：暴力法
     * @author ll
     * @date 2021-12-06 14:07:59
     * @param arr
     * @return boolean
     **/
    public boolean checkIfExist(int[] arr) {
        int[] arrMutiple = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrMutiple[i] = arr[i] * 2;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arrMutiple.length; j++) {
                if (i != j) {
                    if (arr[i] == arrMutiple[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 哈希法
     * @author ll
     * @date 2021-12-06 14:10:06
     * @param arr
     * @return boolean
     **/
    public boolean checkIfExist2(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for (int i : arr) {
            if (i != 0 && list.contains(i * 2)) {
                return true;
            } else if (i == 0) {
                Long collect = list.stream().filter(x -> x == i * 2).collect(Collectors.counting());
                if (collect >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0,0};
        new CheckIntMultipleExist1346().checkIfExist2(arr);
    }
}
