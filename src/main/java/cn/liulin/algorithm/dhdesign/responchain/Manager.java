package cn.liulin.algorithm.dhdesign.responchain;

/**
 * cn.liulin.algorithm.dhdesign.zzl$
 * 管理类
 * @author ll
 * @date 2021-03-12 09:53:31
 **/
public abstract class Manager {

    private String name;

    private Manager superior;

    public Manager(String name) {
        this.name = name;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    public String getName() {
        return name;
    }

    public Manager getSuperior() {
        return superior;
    }

    public abstract void handleRequest(Request request);
}
