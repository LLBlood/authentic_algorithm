package cn.liulin.algorithm.antlr4.array;

/**
 * cn.liulin.algorithm.antlr4$
 *
 * @author ll
 * @date 2023-02-06 16:05:17
 **/
public class ShortToUnicodeStringListener extends ArrayInitBaseListener {

    /**
     * 将 { 翻译为 "
     */
    @Override
    public void enterInit(ArrayInitParser.InitContext ctx) {
        System.out.print("\"");
    }

    /**
     * 将 } 翻译为 "
     */
    @Override
    public void exitInit(ArrayInitParser.InitContext ctx) {
        System.out.print("\"");
    }

    /**
     * 将每个整数翻译为四位的十六进制形式，然后加前缀
     **/
    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx) {
        // 假定不存在嵌套结构
        int value = Integer.valueOf(ctx.INT().getText());
        System.out.printf("\\u%04x", value);
    }
}
