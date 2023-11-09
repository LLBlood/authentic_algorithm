package cn.liulin.algorithm.myself.jdk.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * cn.liulin.algorithm.myself.jdk.thread$
 *
 * @author ll
 * @date 2023-11-09 14:37:31
 **/
public class MyWait {
    public synchronized void before() {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before");
        this.notifyAll();
    }

    public synchronized void after() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        MyWait myWait = new MyWait();
        executorService.execute(() -> myWait.after());
        executorService.execute(() -> myWait.before());
    }
}
