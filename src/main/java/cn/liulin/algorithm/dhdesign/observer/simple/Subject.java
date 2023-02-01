package cn.liulin.algorithm.dhdesign.observer.simple;

import java.util.LinkedList;
import java.util.List;

/**
 * cn.liulin.algorithm.dhdesign.observer.simple$
 *
 * @author ll
 * @date 2023-02-01 16:19:28
 **/
public abstract class Subject {

    private final List<ObServer> list = new LinkedList<>();

    public void attach(ObServer obServer) {
        list.add(obServer);
    }
    public void detach(ObServer obServer) {
        list.remove(obServer);
    }
    public void notifyObServer() {
        for (ObServer obServer : list) {
            obServer.update();
        }
    }
}
