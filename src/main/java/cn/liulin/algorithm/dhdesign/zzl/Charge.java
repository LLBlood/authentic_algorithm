package cn.liulin.algorithm.dhdesign.zzl;

/**
 * cn.liulin.algorithm.dhdesign.zzl$
 * 主管最多能批2天假
 * @author ll
 * @date 2021-03-12 09:57:07
 **/
public class Charge extends Manager{

    public Charge(String name) {
        super(name);
    }

    @Override
    public void handleRequest(Request request) {
        if ("请假".equals(request.getRequestType()) && request.getRequestNumber() <= 2) {
            System.out.println(getName() + ":" + request.getRequestContent() + "数量" + request.getRequestNumber() + "被批准");
        } else {
            if (getSuperior() != null) {
                getSuperior().handleRequest(request);
            }
        }
    }
}
