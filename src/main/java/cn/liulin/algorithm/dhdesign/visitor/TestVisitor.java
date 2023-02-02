package cn.liulin.algorithm.dhdesign.visitor;

/**
 * cn.liulin.algorithm.dhdesign.visitor$
 *
 * @author ll
 * @date 2023-02-02 13:43:44
 **/
public class TestVisitor {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new ConcreteElementA());
        objectStructure.attach(new ConcreteElementB());
        ConcreteVisitorA concreteVisitorA = new ConcreteVisitorA();
//        ConcreteVisitorB concreteVisitorB = new ConcreteVisitorB();
        objectStructure.accept(concreteVisitorA);
//        objectStructure.accept(concreteVisitorB);
    }
}
