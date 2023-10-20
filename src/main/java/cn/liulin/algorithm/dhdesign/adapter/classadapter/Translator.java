package cn.liulin.algorithm.dhdesign.adapter.classadapter;

/**
 * cn.liulin.algorithm.dhdesign.adapter.classadapter$
 *
 * @author ll
 * @date 2023-10-20 14:18:58
 **/
public class Translator {
    public void translateEn(String words) {
        if ("你好世界！".equals(words)) {
            System.out.println("翻译成英文：Hello World！");
        }
    }

    public void translateZh(String words) {
        if ("Hello World！".equals(words)) {
            System.out.println("翻译成中文：你好世界！");
        }
    }
}
