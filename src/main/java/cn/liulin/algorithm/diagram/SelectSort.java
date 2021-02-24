package cn.liulin.algorithm.diagram;

import com.alibaba.fastjson.JSON;

/**
 * cn.liulin.algorithm.diagram$
 * 选择排序 <br/>
 * 先找出最小的，再找出第二小的，然后排序
 * @author ll
 * @date 2021-02-24 13:45:13
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[] {151,2,343,53,65,75,23,12,14,6,67,87};
        selectSortByMin(array);
        System.out.println(JSON.toJSONString(array));
    }

    /**
     * 选择排序<br/>
     * 从小到大排列
     * @author ll
     * @date 2021-02-24 13:47:14
     * @param array
     * @return int[]
     **/
    private static void selectSortByMin(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            int minArg = array[minIndex];
            for (int j = i + 1; j < array.length; j++) {
                int tempIndex = j;
                int tempArg = array[tempIndex];
                if (minArg > tempArg) {
                    minIndex = tempIndex;
                    minArg = tempArg;
                }
            }
            if (minIndex != i) {
                //交换两索引处的值
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
}
