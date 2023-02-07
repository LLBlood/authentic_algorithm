package cn.liulin.algorithm.antlr4.labeledexpr;

import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.antlr4.labeledexpr$
 *
 * @author ll
 * @date 2023-02-07 13:59:07
 **/
public class EvalVisitor extends LabeledExprBaseVisitor<Integer> {

    // 计算机的"内存"，存放变量名和变量值的对应关系

    Map<String, Integer> memory = new HashMap<>();

    /**
     * expr NEWLINE
     */
    @Override
    public Integer visitPrintExpr(LabeledExprParser.PrintExprContext ctx) {
        // 计算expr子节点的值
        Integer value = visit(ctx.expr());
        // 打印结果
        System.out.println(value);
        // 上面已经直接打印出了结果，因此在这里返回一个假值即可
        return 0;
    }

    /**
     * ID '=' expr NEWLINE
     */
    @Override
    public Integer visitAssign(LabeledExprParser.AssignContext ctx) {
        // id 在 '=' 左侧
        String id = ctx.ID().getText();
        // 计算右侧表达式的值
        Integer value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    /**
     * expr ('*'|'/') expr
     */
    @Override
    public Integer visitMulDiv(LabeledExprParser.MulDivContext ctx) {
        // 计算左侧子表达式的值
        Integer left = visit(ctx.expr(0));
        // 计算右侧子表达式的值
        Integer right = visit(ctx.expr(1));
        if (LabeledExprLexer.MUL == ctx.op.getType()) {
            return left * right;
        }
        return left / right;
    }

    /**
     * expr ('+'|'-') expr
     */
    @Override
    public Integer visitAddSub(LabeledExprParser.AddSubContext ctx) {
        // 计算左侧子表达式的值
        Integer left = visit(ctx.expr(0));
        // 计算右侧子表达式的值
        Integer right = visit(ctx.expr(1));
        if (LabeledExprLexer.ADD == ctx.op.getType()) {
            return left + right;
        }
        return left - right;
    }

    /**
     * ID
     */
    @Override
    public Integer visitId(LabeledExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        return memory.getOrDefault(id, 0);
    }

    /**
     * INT
     */
    @Override
    public Integer visitInt(LabeledExprParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    @Override
    public Integer visitParents(LabeledExprParser.ParentsContext ctx) {
        return visit(ctx.expr());
    }
}
