package cn.liulin.algorithm.dhdesign.observer.middle;

/**
 * cn.liulin.algorithm.dhdesign.observer.middle$
 *
 * @author ll
 * @date 2023-02-01 18:09:09
 **/
public class TestEventOb {
    public static void main(String[] args) {
        ConcreteEventSubject concreteEventSubject = new ConcreteEventSubject("通知者米米");
        SubjectOne subjectOne = new SubjectOne("观察者1", concreteEventSubject);
        Event event = new Event(subjectOne, "oneUpdate", "喳喳");
        concreteEventSubject.addEvent(event);
        SubjectTwo subjectTwo = new SubjectTwo("观察者2", concreteEventSubject);
        Event event2 = new Event(subjectTwo, "twoUpdate", "你好菜吗");
        concreteEventSubject.addEvent(event2);
        concreteEventSubject.notifyEvents();
    }
}
