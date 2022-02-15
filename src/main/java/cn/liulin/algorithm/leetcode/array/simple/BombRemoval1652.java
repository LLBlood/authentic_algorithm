package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 1652. 拆炸弹
 * @author ll
 * @date 2022-02-15 14:03:59
 **/
public class BombRemoval1652 {
    public int[] decrypt(int[] code, int k) {
        int[] arr = new int[code.length];
        if (k == 0) {
            for (int i = 0; i < code.length; i++) {
                code[i] = 0;
            }
            return code;
        } else if (k > 0) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += code[i];
            }
            for (int i = 0; i < code.length; i++) {
                sum = sum - code[i] + code[k % code.length];
                k++;
                arr[i] = sum;
            }
        } else {
            int sum = 0;
            for (int i = k; i < 0; i++) {
                sum += code[(i + code.length) % code.length];
            }
            for (int i = 0; i < code.length; i++) {
                arr[i] = sum;
                sum = sum + code[i] - code[(k + code.length) % code.length];
                k++;
            }
        }
        return arr;
    }
}
