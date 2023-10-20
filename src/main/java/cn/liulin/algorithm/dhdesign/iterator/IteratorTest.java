package cn.liulin.algorithm.dhdesign.iterator;

import com.alibaba.fastjson.JSON;

/**
 * cn.liulin.algorithm.dhdesign.iterator$
 *
 * @author ll
 * @date 2023-10-20 14:10:02
 **/
public class IteratorTest {
    public static void main(String[] args) {
        ClassList classList = new ClassList();
        classList.addStudent(new Student("王五", 15));
        classList.addStudent(new Student("零五", 25));
        classList.addStudent(new Student("零我五", 95));
        StudentIterator iterator = classList.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            System.out.println(JSON.toJSONString(next));
        }
    }
}
