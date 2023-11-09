package cn.liulin.algorithm.myself.jdk.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * cn.liulin.algorithm.myself.jdk.thread$
 *
 * @author ll
 * @date 2023-11-09 14:47:00
 **/
public class MyAwait {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before() {
        lock.lock();
        try {
            System.out.println("before");
            Thread.sleep(10000L);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void after() {
        lock.lock();
        try {
            condition.await();
            System.out.println("after2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        MyAwait myAwait = new MyAwait();
        executorService.execute(() -> myAwait.after());
        Thread.sleep(1L);
        executorService.execute(() -> myAwait.before());
    }
}
