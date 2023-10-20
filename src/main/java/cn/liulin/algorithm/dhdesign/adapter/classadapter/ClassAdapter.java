package cn.liulin.algorithm.dhdesign.adapter.classadapter;

/**
 * cn.liulin.algorithm.dhdesign.adapter.classadapter$
 *
 * @author ll
 * @date 2023-10-20 14:20:49
 **/
public class ClassAdapter extends Translator implements target {
    @Override
    public void translate(String source, String target, String words) {
        if ("中文".equals(source) && "英文".equals(target)) {
            this.translateEn(words);
        } else {
            this.translateZh(words);
        }
    }
}
