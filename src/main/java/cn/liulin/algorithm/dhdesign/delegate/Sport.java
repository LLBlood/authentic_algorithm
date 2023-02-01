package cn.liulin.algorithm.dhdesign.delegate;

/**
 * cn.liulin.algorithm.dhdesign.wp$
 *
 * @author ll
 * @date 2021-03-24 16:12:52
 **/
public class Sport {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        monitor.doSport("篮球");
        monitor.doSport("唱歌");
    }
}
