package cn.liulin.algorithm.dhdesign.iterator;

/**
 * cn.liulin.algorithm.dhdesign.iterator$
 *
 * @author ll
 * @date 2023-10-20 14:05:35
 **/
public class Student {
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
