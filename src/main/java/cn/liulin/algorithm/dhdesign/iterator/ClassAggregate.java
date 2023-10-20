package cn.liulin.algorithm.dhdesign.iterator;

/**
 * cn.liulin.algorithm.dhdesign.iterator$
 *
 * @author ll
 * @date 2023-10-20 14:05:46
 **/
public interface ClassAggregate {
    StudentIterator iterator();
    void addStudent(Student student);
}
