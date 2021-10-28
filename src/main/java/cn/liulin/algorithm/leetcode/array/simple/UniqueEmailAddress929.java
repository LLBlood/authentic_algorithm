package cn.liulin.algorithm.leetcode.array.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 929. 独特的电子邮件地址
 * @author ll
 * @date 2021-10-28 10:56:45
 **/
public class UniqueEmailAddress929 {
    /**
     * 自定义：哈希
     * @author ll
     * @date 2021-10-28 11:13:54
     * @param emails
     * @return int
     **/
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int i = email.indexOf("@");
            String endStr = email.substring(i, email.length());
            String dealStr = email.substring(0, i);
            int i1 = dealStr.indexOf("+");
            if (i1 != -1) {
                dealStr = dealStr.substring(0, i1);
            }
            dealStr = dealStr.replaceAll("\\.", "");
            set.add(dealStr + endStr);
        }
        return set.size();
    }
}
