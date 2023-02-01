package cn.liulin.algorithm.dhdesign.observer.middle;

/**
 * cn.liulin.algorithm.dhdesign.observer.middle$
 *
 * @author ll
 * @date 2023-02-01 18:06:38
 **/
public class SubjectTwo {
    private String name;
    private ConcreteEventSubject concreteEventSubject;

    public SubjectTwo(String name, ConcreteEventSubject concreteEventSubject) {
        this.name = name;
        this.concreteEventSubject = concreteEventSubject;
    }

    public void twoUpdate(String str) {
        System.out.println("通知者" + this.concreteEventSubject.getName() + "，观察者" + this.name + "的twoUpdate方法执行了,接收到的参数为:" + str);
    }
}
