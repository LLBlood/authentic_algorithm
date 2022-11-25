package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1603. 设计停车系统
 * @author ll
 * @date 2022-11-25 14:16:35
 **/
public class DesignParking1603 {
    int[] arr = new int[4];
    public DesignParking1603(int big, int medium, int small) {
        arr[1] = big;
        arr[2] = medium;
        arr[3] = small;
    }

    public boolean addCar(int carType) {
        if (arr[carType] > 0) {
            arr[carType]--;
            return true;
        }
        return false;
    }
}
