package cn.liulin.algorithm.diagram;

import com.alibaba.fastjson.JSON;

/**
 * cn.liulin.algorithm.diagram$
 * 快速排序学习<br/>
 * 挖坑法+分而治之
 * @author ll
 * @date 2021-02-25 13:16:14
 **/
public class QuickSortStudy {
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
     * @param lowIndex
     * @param highIndex
     **/
    private static void quickSortByMin(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int baseX = array[lowIndex];
        int minIndex = lowIndex;
        int maxIndex = highIndex;
        while (lowIndex < highIndex) {
            while (lowIndex < highIndex && array[highIndex] >= baseX) {
                highIndex--;
            }
            if (lowIndex < highIndex) {
                array[lowIndex++] = array[highIndex];
            }
            while (lowIndex < highIndex && array[lowIndex] < baseX) {
                lowIndex++;
            }
            if (lowIndex < highIndex) {
                array[highIndex--] = array[lowIndex];
            }
        }
        array[lowIndex] = baseX;
        quickSortByMin(array, minIndex, lowIndex - 1);
        quickSortByMin(array, lowIndex + 1, maxIndex);
    }
}
