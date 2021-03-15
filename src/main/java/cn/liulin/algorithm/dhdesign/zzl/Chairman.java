package cn.liulin.algorithm.dhdesign.zzl;

/**
 * cn.liulin.algorithm.dhdesign.zzl$
 * 董事长负责所有请求
 * @author ll
 * @date 2021-03-15 15:24:24
 **/
public class Chairman extends Manager {
    public Chairman(String name) {
        super(name);
    }

    @Override
    public void handleRequest(Request request) {
        if ("请假".equals(request.getRequestType())) {
            System.out.println(getName() + ":" + request.getRequestContent() + "数量" + request.getRequestNumber() + "被批准");
        } else if ("加薪".equals(request.getRequestType()) && request.getRequestNumber() <= 500) {
            System.out.println(getName() + ":" + request.getRequestContent() + "数量" + request.getRequestNumber() + "被批准");
        } else {
            System.out.println(getName() + ":" + request.getRequestContent() + "数量" + request.getRequestNumber() + "再说吧");
        }
    }
}
