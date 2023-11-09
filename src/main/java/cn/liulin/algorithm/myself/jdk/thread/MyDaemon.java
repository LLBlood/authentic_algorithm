package cn.liulin.algorithm.myself.jdk.thread;

/**
 * cn.liulin.algorithm.myself.jdk.thread$
 *
 * @author ll
 * @date 2023-11-02 17:39:15
 **/
public class MyDaemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.setDaemon(true);
        thread.start();
        System.out.println("===> end");
    }
}
