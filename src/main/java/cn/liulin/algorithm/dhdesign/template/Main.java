package cn.liulin.algorithm.dhdesign.template;

/**
 * cn.liulin.algorithm.dhdesign.mb$
 *
 * @author ll
 * @date 2021-06-07 14:48:30
 **/
public class Main {
    public static void main(String[] args) {
        TestPaper testPaperA = new TestPaperA();
        testPaperA.setName("路人A");
        testPaperA.testQuestion1();
        testPaperA.testQuestion2();
        testPaperA.testQuestion3();

        TestPaper testPaperB = new TestPaperB();
        testPaperB.setName("路人B");
        testPaperB.testQuestion1();
        testPaperB.testQuestion2();
        testPaperB.testQuestion3();
    }
}
