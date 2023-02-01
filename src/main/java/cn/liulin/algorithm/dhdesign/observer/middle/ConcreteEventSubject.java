package cn.liulin.algorithm.dhdesign.observer.middle;

/**
 * cn.liulin.algorithm.dhdesign.observer.middle$
 *
 * @author ll
 * @date 2023-02-01 18:04:44
 **/
public class ConcreteEventSubject extends EventHandle {
    private String name;

    public ConcreteEventSubject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
