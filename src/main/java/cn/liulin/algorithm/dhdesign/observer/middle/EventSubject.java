package cn.liulin.algorithm.dhdesign.observer.middle;

/**
 * cn.liulin.algorithm.dhdesign.observer.middle$
 *
 * @author ll
 * @date 2023-02-01 18:02:01
 **/
public abstract class EventSubject {

    private EventHandle eventHandle = new EventHandle();

    public void attach(Object obj, String methodName, Object...args) {
        Event event = new Event(obj, methodName, args);
        eventHandle.addEvent(event);
    }

    public void detach(Object obj, String methodName, Object...args) {
        Event event = new Event(obj, methodName, args);
        eventHandle.removeEvent(event);
    }

    public void notifyObservers() {
        eventHandle.notifyEvents();
    }
}
