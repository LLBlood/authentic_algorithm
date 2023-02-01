package cn.liulin.algorithm.dhdesign.observer.simple;

/**
 * cn.liulin.algorithm.dhdesign.observer.simple$
 *
 * @author ll
 * @date 2023-02-01 16:31:24
 **/
public class TestOb {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        ConcreteObServer concreteObServer1 = new ConcreteObServer(concreteSubject, "A");
        ConcreteObServer concreteObServer2 = new ConcreteObServer(concreteSubject, "B");
        ConcreteObServer concreteObServer3 = new ConcreteObServer(concreteSubject, "C");
        concreteSubject.attach(concreteObServer1);
        concreteSubject.attach(concreteObServer2);
        concreteSubject.attach(concreteObServer3);
        concreteSubject.setSubjectState("哈哈哈");
        concreteSubject.notifyObServer();
    }
}
