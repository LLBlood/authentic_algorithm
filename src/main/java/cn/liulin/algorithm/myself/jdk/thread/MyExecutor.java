package cn.liulin.algorithm.myself.jdk.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * cn.liulin.algorithm.myself.jdk.thread$
 *
 * @author ll
 * @date 2023-11-02 17:35:42
 **/
public class MyExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new MyRunnable());
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        executorService1.execute(new MyRunnable());
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        executorService2.execute(new MyRunnable());
    }
}
