package cn.liulin.algorithm.dhdesign.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * cn.liulin.algorithm.dhdesign.iterator$
 *
 * @author ll
 * @date 2023-10-20 14:07:01
 **/
public class ClassList implements ClassAggregate {
    private final List<Student> students = new ArrayList<>();

    @Override
    public StudentIterator iterator() {
        return new StudentIteratorImpl(students);
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }
}
