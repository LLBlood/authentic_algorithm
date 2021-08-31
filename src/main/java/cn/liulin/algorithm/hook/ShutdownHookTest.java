package cn.liulin.algorithm.hook;

/**
 * cn.liulin.algorithm.hook$
 *
 * @author ll
 * @date 2021-08-31 15:49:58
 **/
public class ShutdownHookTest {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            new Thread("thread1") {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":输出1");
                }
            }.start();
            new Thread("thread2") {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":输出2");
                }
            }.start();
            i++;
            if (i == 5) {
                break;
            }
            if (i == 3) {
                System.exit(0);
            }
            Thread thread = new Thread("shutdownThread") {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":输出shutdown");
                }
            };
            Runtime.getRuntime().addShutdownHook(thread);
        }
    }
}
