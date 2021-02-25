package cn.liulin.algorithm.diagram;

/**
 * cn.liulin.algorithm.diagram$
 * 递归<br/>
 * 计算5!
 * @author ll
 * @date 2021-02-25 11:18:42
 **/
public class Recursion {
    public static void main(String[] args) {
        int arg = 5;
        int value = getFactorial(arg);
        System.out.println(arg + "的阶乘结果为:" + value);
    }

    private static int getFactorial(int arg) {
        if (arg <= 1) {
            //基线条件
            return 1;
        }
        //递归条件
        return arg * getFactorial(arg - 1);
    }
}
