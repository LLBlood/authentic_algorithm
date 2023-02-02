package cn.liulin.algorithm.dhdesign.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.dhdesign.visitor$
 *
 * @author ll
 * @date 2023-02-02 13:37:55
 **/
public class ObjectStructure {
    private List<Element> elements = new LinkedList<>();
    public void attach(Element element) {
        elements.add(element);
    }
    public void detach(Element element) {
        elements.remove(element);
    }
    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }

    }
}
