package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 717. 1比特与2比特字符
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10或11)来表示。
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 * @author ll
 * @date 2021-10-18 14:17:18
 **/
public class OneBitAndTwoBitCharacters717 {
    /**
     * 只与最后一个0前面的1有关，其他的0不管
     * 比图11010，最后一个0前面只有1个1，11110前面有4个1
     * @author ll
     * @date 2021-10-18 14:50:08
     * @param bits
     * @return boolean
     **/
    public boolean isOneBitCharacter(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) {
            i--;
        }
        return (bits.length - i) % 2 == 0;
    }

    public static void main(String[] args) {
        int[] bits = {1,1,1,1,0};
        System.out.println(new OneBitAndTwoBitCharacters717().isOneBitCharacter(bits));
    }
}
