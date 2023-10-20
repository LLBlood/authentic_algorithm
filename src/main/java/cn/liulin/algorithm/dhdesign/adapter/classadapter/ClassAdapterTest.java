package cn.liulin.algorithm.dhdesign.adapter.classadapter;

/**
 * cn.liulin.algorithm.dhdesign.adapter.classadapter$
 *
 * @author ll
 * @date 2023-10-20 14:21:54
 **/
public class ClassAdapterTest {
    public static void main(String[] args) {
        ClassAdapter classAdapter = new ClassAdapter();
        classAdapter.translate("中文","英文","你好世界！");
        classAdapter.translate("英文","中文","Hello World！");
    }
}
