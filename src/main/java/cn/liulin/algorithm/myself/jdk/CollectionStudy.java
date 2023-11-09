package cn.liulin.algorithm.myself.jdk;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * cn.liulin.algorithm.myself.jdk$
 *
 * @author ll
 * @date 2023-10-20 15:57:55
 **/
public class CollectionStudy {
    public static void main(String[] args) {
        /**
         *  private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
         *  1.ArrayList是基于数组实现的 this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
         *  RandomAccess接口标识着该类支持快速随机访问
         *  2.⽤ ensureCapacityInternal() ⽅法来保证容量⾜够，如果不够时，需要使⽤ grow() ⽅法进
         *  ⾏扩容，新容量的⼤⼩为 oldCapacity + (oldCapacity >> 1) ，即 oldCapacity+oldCapacity/2。其
         *  中 oldCapacity >> 1 需要取整，所以新容量⼤约是旧容量的 1.5 倍左右。（oldCapacity 为偶数就是
         *  1.5 倍，为奇数就是 1.5 倍-0.5
         *  3.扩容操作需要调⽤ Arrays.copyOf() 把原数组整个复制到新数组中
         *  4.需要调⽤ System.arraycopy() 将 index+1 后⾯的元素都复制到 index 位置上
         *
         */

        List<Integer> list = new ArrayList<>();

        int[] arr = {0,1,2,3,4,5};
        System.arraycopy(arr, 3, arr, 2, 3);
        arr[arr.length - 1] = 0;
        for (int i : arr) {
            System.out.print(i);
        }

        /**
         * vector线程安全，默认每次扩大2倍
         */
        List<Integer> vector = new Vector<>();

        /**
         * 不改变底层结构，用同步代码块，看起来没啥区别
         */
        List<Integer> synList = Collections.synchronizedList(list);

        /**
         * 线程安全，返回的是副本
         */
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        /**
         * 内部是双向链表，查找慢，删除快
         */
        List<Integer> linkedList = new LinkedList<>();

        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new Hashtable<>();
        Map<String, String> map3 = new ConcurrentHashMap<>();
        Map<String, String> map4 = new LinkedHashMap<>();
        Map<String, String> map5 = new WeakHashMap<>();
    }
}
