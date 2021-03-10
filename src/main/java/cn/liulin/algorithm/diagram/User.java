package cn.liulin.algorithm.diagram;

import java.util.Date;

/**
 * cn.liulin.algorithm.diagram$
 *
 * @author ll
 * @date 2021-03-09 17:38:09
 **/
public class User extends Test1 {
    private String name;
    private Integer sex;
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
