package cn.liulin.algorithm.dhdesign.observer.simple;

import java.util.List;

/**
 * cn.liulin.algorithm.dhdesign.observer.simple$
 *
 * @author ll
 * @date 2023-02-01 16:24:35
 **/
public class ConcreteSubject extends Subject {
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
