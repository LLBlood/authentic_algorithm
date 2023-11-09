package cn.liulin.algorithm.myself.jdk.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * cn.liulin.algorithm.myself.jdk.thread$
 *
 * @author ll
 * @date 2023-11-02 17:54:46
 **/
public class MyExecutorShut {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            while (true) {
                System.out.println("====>1111");
            }
        });
        executorService.execute(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("====>2222");
            }
        });
        executorService.shutdown();
        executorService.shutdownNow();
    }
}
