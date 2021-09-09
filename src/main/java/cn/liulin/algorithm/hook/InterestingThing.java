package cn.liulin.algorithm.hook;

import java.math.BigDecimal;

/**
 * cn.liulin.algorithm.hook$
 *
 * @author ll
 * @date 2021-09-03 09:12:47
 **/
public class InterestingThing {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("100.0000");
        BigDecimal bigDecimal1 = bigDecimal.setScale(2);
        System.out.println(bigDecimal1);
        System.out.println(true | false);
        System.out.println(true || false);
        System.out.println(true | true);
        System.out.println(true || true);
        System.out.println(false | false);
        System.out.println(false || false);
        try {
            int i = 1/ 0;
        } catch (Exception e) {
            System.out.println(String.format("%s", e));
        }
    }
}
