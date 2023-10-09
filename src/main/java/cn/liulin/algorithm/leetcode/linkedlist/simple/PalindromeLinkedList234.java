package cn.liulin.algorithm.leetcode.linkedlist.simple;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * cn.liulin.algorithm.leetcode.linkedlist.simple$
 *
 * @author ll
 * @date 2023-10-08 15:25:34
 **/
public class PalindromeLinkedList234 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\IdeaWorkSpace_Study\\authentic_algorithm\\src\\main\\resources\\cn\\liulin\\algorithm\\data\\input.txt")));
        StringBuilder sb = new StringBuilder();
        while (bufferedReader.ready()) {
            sb.append(bufferedReader.readLine());
        }
        int start = 0;
        int end = sb.length() - 1;
        while (start < end) {
            if (sb.charAt(start) != sb.charAt(end)) {
                System.out.println(false);
                break;
            }
            start++;
            end--;
        }
        System.out.println(true);
    }
}
