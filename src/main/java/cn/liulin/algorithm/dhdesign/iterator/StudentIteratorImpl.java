package cn.liulin.algorithm.dhdesign.iterator;

import java.util.List;

/**
 * cn.liulin.algorithm.dhdesign.iterator$
 *
 * @author ll
 * @date 2023-10-20 14:07:37
 **/
public class StudentIteratorImpl implements StudentIterator {

    private List<Student> list;
    private int index;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.size() > index;
    }

    @Override
    public Student next() {
        return list.get(index++);
    }
}
