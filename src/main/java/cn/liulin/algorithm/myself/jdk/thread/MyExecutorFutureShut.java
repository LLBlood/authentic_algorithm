package cn.liulin.algorithm.myself.jdk.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * cn.liulin.algorithm.myself.jdk.thread$
 *
 * @author ll
 * @date 2023-11-02 17:57:24
 **/
public class MyExecutorFutureShut {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Object> submit1 = executorService.submit(() -> {
            while (true) {
                System.out.println("====>1111");
            }
        });
        Future<?> submit2 = executorService.submit(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("====>2222");
            }
        });
        submit1.cancel(true);
        submit2.cancel(true);
    }
}
