package cn.liulin.algorithm.leetcode.code.simple;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 1356. 根据数字二进制下 1 的数目排序
 * @author ll
 * @date 2022-11-25 09:33:08
 **/
public class SortAccording1356 {
    public int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                int i1 = arr[j];
                int i2 = arr[j + 1];
                int count1 = 0;
                int count2 = 0;
                while (i1 != 0) {
                    if ((i1 & 1) == 1) {
                        count1++;
                    }
                    i1 = i1 >> 1;
                }
                while (i2 != 0) {
                    if ((i2 & 1) == 1) {
                        count2++;
                    }
                    i2 = i2 >> 1;
                }
                if (count1 > count2) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else if (count1 == count2 && arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};
        int[] temp = new SortAccording1356().sortByBits(arr);
        System.out.println(JSON.toJSONString(temp));
    }

    public int[] sortByBits2(int[] arr) {
        int[] bit = new int[10001];
        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            list.add(x);
            bit[x] = get(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x /= 2;
        }
        return res;
    }
}
