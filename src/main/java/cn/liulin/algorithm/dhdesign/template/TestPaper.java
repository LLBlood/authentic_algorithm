package cn.liulin.algorithm.dhdesign.template;

/**
 * cn.liulin.algorithm.dhdesign.mb$
 * 所有问题的父类
 * @author ll
 * @date 2021-06-07 14:43:17
 **/
public abstract class TestPaper {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void testQuestion1() {
        System.out.println("今天你吃饭了吗？\na.吃了 b没吃");
        System.out.println(this.name + "答案：" + answer1());
    }

    public void testQuestion2() {
        System.out.println("今天你打游戏了吗？\na.打了 b没打");
        System.out.println(this.name + "答案：" + answer2());
    }

    public void testQuestion3() {
        System.out.println("今天你游泳了吗？\na.游了 b没游");
        System.out.println(this.name + "答案：" + answer3());
    }

    public abstract String answer1();

    public abstract String answer2();
    
    public abstract String answer3();

}
