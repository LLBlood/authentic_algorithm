package cn.liulin.algorithm.leetcode.code.simple;

/**
 * cn.liulin.algorithm.leetcode.code.simple$
 * 67. 二进制求和
 * @author ll
 * @date 2022-12-09 09:56:38
 **/
public class BinarySummation67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aL = a.length() - 1;
        int bL = b.length() - 1;
        int more = 0;
        while (aL >= 0 || bL >= 0) {
            int aI = 0;
            if (aL >= 0) {
                aI = a.charAt(aL) - '0';
            }
            int bI = 0;
            if (bL >= 0) {
                bI = b.charAt(bL) - '0';
            }
            int i = aI + bI + more;
            int i1 = i % 2;
            sb.append(i1);
            more = i / 2;
            aL--;
            bL--;
        }
        if (more > 0) {
            sb.append(more);
        }
        return sb.reverse().toString();
    }
}
