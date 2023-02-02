package cn.liulin.algorithm.dhdesign.visitor;

/**
 * cn.liulin.algorithm.dhdesign.visitor$
 *
 * @author ll
 * @date 2023-02-02 13:37:27
 **/
public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.concreteElementB(this);
    }
}
