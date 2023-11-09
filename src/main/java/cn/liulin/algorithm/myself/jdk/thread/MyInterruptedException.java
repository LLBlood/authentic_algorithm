package cn.liulin.algorithm.myself.jdk.thread;

/**
 * cn.liulin.algorithm.myself.jdk.thread$
 *
 * @author ll
 * @date 2023-11-02 17:45:33
 **/
public class MyInterruptedException {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("======> run start");
                Thread.sleep(10000L);
                System.out.println("======> run end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.interrupt();
        System.out.println("====> main end");
    }
}
