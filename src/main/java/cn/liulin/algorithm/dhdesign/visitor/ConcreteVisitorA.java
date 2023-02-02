package cn.liulin.algorithm.dhdesign.visitor;

/**
 * cn.liulin.algorithm.dhdesign.visitor$
 *
 * @author ll
 * @date 2023-02-02 13:41:30
 **/
public class ConcreteVisitorA implements Visitor {
    @Override
    public void concreteElementA(ConcreteElementA concreteElementA) {
        System.out.printf("%s被%s访问", concreteElementA.getClass().getName(), this.getClass().getName());
        System.out.println();
    }

    @Override
    public void concreteElementB(ConcreteElementB concreteElementB) {
        System.out.printf("%s被%s访问", concreteElementB.getClass().getName(), this.getClass().getName());
        System.out.println();
    }
}
