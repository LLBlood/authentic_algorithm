package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1184. 公交站间的距离
 * @author ll
 * @date 2021-11-03 17:19:05
 **/
public class DistanceBetweenBusStops1184 {
    /**
     * 自定义：求解法
     * @author ll
     * @date 2021-11-03 17:33:56
     * @param distance
     * @param start
     * @param destination
     * @return int
     **/
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int min = Math.min(start, destination);
        int max = Math.max(start, destination);
        int length = 0;
        int rL = 0;
        for (int i = min; i < max; i++) {
            length += distance[i];
        }
        for (int i = 0; i < min; i++) {
            rL += distance[i];
        }
        for (int i = max; i < distance.length; i++) {
            rL += distance[i];
        }
        return Math.min(length, rL);
    }

    public int distanceBetweenBusStops2(int[] distance, int start, int destination) {
        int length = 0;
        int rL = 0;
        for (int i = start; i != destination; i = (i + 1) % distance.length) {
            length += distance[i];
        }
        for (int i = destination; i != start; i = (i + 1) % distance.length) {
            rL += distance[i];
        }
        return Math.min(length, rL);
    }
}
