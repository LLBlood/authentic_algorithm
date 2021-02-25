package cn.liulin.algorithm.diagram;

import com.alibaba.fastjson.JSON;

/**
 * cn.liulin.algorithm.diagram$
 * 快速排序<br/>
 * @author ll
 * @date 2021-02-25 13:16:14
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[] {151,2,343,53,65,75,23,12,14,6,67,87};
        quickSortByMin(array, 0, array.length - 1);
        System.out.println(JSON.toJSONString(array));
    }

    /**
     * 快速排序
     * @author ll
     * @date 2021-02-25 17:15:17
     * @param array
     * @param low
     * @param high
     * @return void
     **/
    private static void quickSortByMin(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        //选定基准值
        int baseX = array[low];
        int min = low;
        int max = high;
        while (low < high) {
            while (high > low && array[high] >= baseX) {
                high--;
            }
            if (high > low) {
                array[low] = array[high];
                low++;
            }
            while (high > low && array[high] < baseX) {
                low++;
            }
            if (high > low) {
                array[high] = array[low];
                high--;
            }
        }
        array[low] = baseX;
        quickSortByMin(array, min, low - 1);
        quickSortByMin(array, low + 1, max);
    }
}
