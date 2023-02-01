package cn.liulin.algorithm.dhdesign.observer.simple;

/**
 * cn.liulin.algorithm.dhdesign.observer.simple$
 *
 * @author ll
 * @date 2023-02-01 16:20:30
 **/
public class ConcreteObServer extends ObServer {

    private String name;
    private String observerState;
    private ConcreteSubject concreteSubject;

    public ConcreteObServer(ConcreteSubject concreteSubject, String name) {
        this.name = name;
        this.concreteSubject = concreteSubject;
    }

    @Override
    public void update() {
        this.observerState = concreteSubject.getSubjectState();
        System.out.printf("观察者%s的新状态是%s%n", this.name, this.observerState);
    }
}
