package cn.liulin.algorithm.myself.jdk.thread;

/**
 * cn.liulin.algorithm.myself.jdk.thread$
 *
 * @author ll
 * @date 2023-11-02 17:49:10
 **/
public class MyInterrupted {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                System.out.println("===> 执行中");
            }
        });
        thread.start();
        thread.interrupt();
        System.out.println("==== main end");
    }
}
