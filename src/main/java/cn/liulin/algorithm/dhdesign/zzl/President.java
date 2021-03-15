package cn.liulin.algorithm.dhdesign.zzl;

/**
 * cn.liulin.algorithm.dhdesign.zzl$
 * 总经理请假最多5天
 * @author ll
 * @date 2021-03-12 10:02:27
 **/
public class President extends Manager {
    public President(String name) {
        super(name);
    }

    @Override
    public void handleRequest(Request request) {
        if ("请假".equals(request.getRequestType()) && request.getRequestNumber() <= 5) {
            System.out.println(getName() + ":" + request.getRequestContent() + "数量" + request.getRequestNumber() + "被批准");
        } else {
            if (getSuperior() != null) {
                getSuperior().handleRequest(request);
            }
        }
    }
}
