package cn.liulin.algorithm.dhdesign.observer.middle;

import java.util.List;
import java.util.Vector;

/**
 * cn.liulin.algorithm.dhdesign.observer.middle$
 *
 * @author ll
 * @date 2023-02-01 17:57:19
 **/
public class EventHandle {
    List<Event> events = new Vector<>();

    public synchronized void addEvent(Event event) {
        if (!events.contains(event)) {
            events.add(event);
        }
    }

    public synchronized void removeEvent(Event event) {
        events.remove(event);
    }

    public void notifyEvents() {
        if (events != null) {
            for (Event event : events) {
                event.invoke();
            }
        }
    }
}
