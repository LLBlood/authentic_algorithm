package cn.liulin.algorithm.myself.jdk.thread;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * cn.liulin.algorithm.myself.jdk.thread$
 *
 * @author ll
 * @date 2023-11-09 10:07:42
 **/
public class MyCLHLock {
    /**
     * 定义一个节点，默认的lock状态为true
     */
    public static class CLHNode {
        private volatile boolean isLocked = true;
    }
    /**
     * 尾部节点,只用一个节点即可
     */
    private volatile CLHNode tail;
    private static final ThreadLocal<CLHNode> LOCAL = new ThreadLocal<>();
    private static final AtomicReferenceFieldUpdater<MyCLHLock, CLHNode> UPDATER = AtomicReferenceFieldUpdater.newUpdater(MyCLHLock.class, CLHNode.class,
            "tail");
    public void lock() {
        // 新建节点并将节点与当前线程保存起来
        CLHNode node = new CLHNode();
        LOCAL.set(node);
        // 将新建的节点设置为尾部节点，并返回旧的节点（原子操作），这里旧的节点实际上就是当前节点的前驱节点
        CLHNode preNode = UPDATER.getAndSet(this, node);
        if (preNode != null) {
            // 前驱节点不为null表示当锁被其他线程占用，通过不断轮询判断前驱节点的锁标志位等待前驱节点释放锁
            while (preNode.isLocked) {
            }
            preNode = null;
            LOCAL.set(node);
        }
        // 如果不存在前驱节点，表示该锁没有被其他线程占用，则当前线程获得锁
    }
    public void unlock() {
        // 获取当前线程对应的节点
        CLHNode node = LOCAL.get();
        // 如果tail节点等于node，则将tail节点更新为null，同时将node的lock状态职位false，表示当前线程释放了锁
        if (!UPDATER.compareAndSet(this, node, null)) {
            node.isLocked = false;
        }
        node = null;
    }
}
