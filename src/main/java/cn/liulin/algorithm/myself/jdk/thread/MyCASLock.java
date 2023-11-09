package cn.liulin.algorithm.myself.jdk.thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * cn.liulin.algorithm.myself.jdk.thread$
 *
 * @author ll
 * @date 2023-11-08 17:52:45
 **/
public class MyCASLock {
    private AtomicReference<Thread> cas = new AtomicReference<>();//进入cas的实现类
    public void lock() {
        // 利用CAS
        Thread thread = Thread.currentThread();
        while (!cas.compareAndSet(null, thread)) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread + "============>未获取锁");
        }
        System.out.println(thread + "已获取锁");
    }
    public void unlock() {
        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);
        System.out.println(current.getName() + "已释放锁");
    }

    public static void main(String[] args) throws InterruptedException {
        MyCASLock myCASLock = new MyCASLock();
        new Thread(() -> {
            myCASLock.lock();
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myCASLock.unlock();
        }).start();
        new Thread(() -> {
            myCASLock.lock();
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myCASLock.unlock();
        }).start();
    }
}
