package cn.liulin.algorithm.diagram;

/**
 * cn.liulin.algorithm.diagram$
 * 二分查找法
 * @author ll
 * @date 2021-02-24 10:41:39
 **/
public class BinarySearchMethod {
    public static void main(String[] args) {
        //假定一个1~100的有序数组
        int[] array = new int[] {1, 3, 5, 7, 8, 10, 23, 32, 43, 54};
        //查找其中一个数所在位置
        int arg = 103;
        int index = queryBinarySearch(array, arg);
        System.out.println(arg + "所在位置位于数组角标" + index);
    }

    /**
     * 二分查找法
     * @author ll
     * @date 2021-02-24 10:45:01
     * @param array 有序数组
     * @param arg 查找参数
     * @return int 参数所在位置，找不到返回-1
     **/
    private static int queryBinarySearch(int[] array, int arg) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            int midArg = array[midIndex];
            if (midArg == arg) {
                return midIndex;
            } else if (midArg < arg) {
                /* 此时midIndex所对应的元素小于目标元素，则startIndex应该midIndex+1 */
                startIndex = midIndex + 1;
            } else {
                /* 此时midIndex所对应的元素大于目标元素，则endIndex应该midIndex+1 */
                endIndex = midIndex - 1;
            }
        }
        return -1;
    }
}
