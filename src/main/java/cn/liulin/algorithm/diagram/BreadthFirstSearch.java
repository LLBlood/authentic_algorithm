package cn.liulin.algorithm.diagram;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * cn.liulin.algorithm.diagram$
 * 广度优先搜索
 * @author ll
 * @date 2021-03-03 14:02:10
 **/
public class BreadthFirstSearch {
    public static void main(String[] args) {
        Map<String, String[]> friendMap = new HashMap<>(1);
        String[] youFriends = {"andi", "anny", "anku"};
        String[] andiFriends = {"biu", "bou", "boy"};
        String[] annyFriends = {"boy", "bob"};
        String[] ankuFriends = {"bocu", "bocv"};
        String[] boyFriends = {"andi"};
        friendMap.put("you", youFriends);
        friendMap.put("andi", andiFriends);
        friendMap.put("anny", annyFriends);
        friendMap.put("anku", ankuFriends);
        friendMap.put("boy", boyFriends);

        //建立存储关系的队列
        Queue<String> queue = new LinkedBlockingQueue<>();
        queue.add("andi");
        queue.add("anny");
        queue.add("anku");

        List<String> useName = new LinkedList<>();

        while (!queue.isEmpty()) {
            String poll = queue.poll();
            if (!useName.contains(poll)) {
                if ("boy".equals(poll)) {
                    System.out.println(poll);
                    break;
                } else {
                    System.out.println(poll);
                    useName.add(poll);
                    String[] strings = friendMap.get(poll);
                    if (strings != null) {
                        queue.addAll(Arrays.asList(strings));
                    }
                }
            }
        }
    }
}
