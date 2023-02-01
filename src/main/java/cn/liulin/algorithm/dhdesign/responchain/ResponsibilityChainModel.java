package cn.liulin.algorithm.dhdesign.responchain;

/**
 * cn.liulin.algorithm.dhdesign$
 * 职责链模式
 * @author ll
 * @date 2021-03-12 09:46:36
 **/
public class ResponsibilityChainModel {
    public static void main(String[] args) {
        Request xiaoming = new Request();
        xiaoming.setRequestContent("小明请假");
        xiaoming.setRequestNumber(2);
        xiaoming.setRequestType("请假");

        Request xiaohong = new Request();
        xiaohong.setRequestContent("小红请假");
        xiaohong.setRequestNumber(5);
        xiaohong.setRequestType("请假");

        Request xiaolan = new Request();
        xiaolan.setRequestContent("小兰加薪");
        xiaolan.setRequestNumber(700);
        xiaolan.setRequestType("加薪");

        Charge charge = new Charge("张三");
        President president = new President("李四");
        Chairman chairman = new Chairman("王麻子");
        charge.setSuperior(president);
        president.setSuperior(chairman);

        charge.handleRequest(xiaoming);
        charge.handleRequest(xiaohong);
        charge.handleRequest(xiaolan);
    }
}
