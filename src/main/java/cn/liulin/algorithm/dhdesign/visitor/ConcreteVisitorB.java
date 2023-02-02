package cn.liulin.algorithm.dhdesign.visitor;

/**
 * cn.liulin.algorithm.dhdesign.visitor$
 *
 * @author ll
 * @date 2023-02-02 13:42:56
 **/
public class ConcreteVisitorB implements Visitor {
    @Override
    public void concreteElementA(ConcreteElementA concreteElementA) {
        System.out.printf("%s打%s", concreteElementA.getClass().getName(), this.getClass().getName());
        System.out.println();
    }

    @Override
    public void concreteElementB(ConcreteElementB concreteElementB) {
        System.out.printf("%s打%s", concreteElementB.getClass().getName(), this.getClass().getName());
        System.out.println();
    }
}
