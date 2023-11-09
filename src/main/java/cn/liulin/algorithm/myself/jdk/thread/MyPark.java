package cn.liulin.algorithm.myself.jdk.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * cn.liulin.algorithm.myself.jdk.thread$
 *
 * @author ll
 * @date 2023-11-09 15:22:19
 **/
public class MyPark {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "被唤醒");
        });
        thread.start();
        new Thread(() -> {
            LockSupport.unpark(thread);
            System.out.println("唤醒动作");
        }).start();
    }
}
