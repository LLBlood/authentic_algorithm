package cn.liulin.algorithm.myself.jdk.thread;

/**
 * cn.liulin.algorithm.myself.jdk.thread$
 *
 * @author ll
 * @date 2023-11-09 14:29:39
 **/
public class MyJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("=====> t1执行结束");
        });
        t1.start();
        t1.join();
        System.out.println("======> main执行结束");
    }
}
