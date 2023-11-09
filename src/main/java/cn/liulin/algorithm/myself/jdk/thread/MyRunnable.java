package cn.liulin.algorithm.myself.jdk.thread;

/**
 * cn.liulin.algorithm.myself.jdk.thread$
 *
 * @author ll
 * @date 2023-11-02 17:18:31
 **/
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("=======> start");
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=======> end");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        System.out.println("=======> main end");
    }
}
