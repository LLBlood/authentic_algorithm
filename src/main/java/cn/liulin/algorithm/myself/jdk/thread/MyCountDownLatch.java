package cn.liulin.algorithm.myself.jdk.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * cn.liulin.algorithm.myself.jdk.thread$
 *
 * @author ll
 * @date 2023-11-09 15:32:39
 **/
public class MyCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            int finalI = i;
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "正在执行中" + finalI);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("结束执行");
        executorService.shutdown();
    }
}
