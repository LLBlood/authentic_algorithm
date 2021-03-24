package cn.liulin.algorithm.dhdesign.wp;

import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.dhdesign.wp$
 * 班长
 * @author ll
 * @date 2021-03-24 16:06:24
 **/
public class Monitor implements Person{

    private Map<String, Person> mapper = new HashMap<>();
    public Monitor() {
        mapper.put("篮球", new PhysicalEducation());
        mapper.put("唱歌", new MusicEducation());
    }

    @Override
    public void doSport(String sportName) {
        mapper.get(sportName).doSport(sportName);
    }
}
