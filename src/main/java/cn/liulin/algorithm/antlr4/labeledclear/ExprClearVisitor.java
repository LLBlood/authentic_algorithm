package cn.liulin.algorithm.antlr4.labeledclear;

import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.antlr4.labeledclear$
 *
 * @author ll
 * @date 2023-02-07 14:52:51
 **/
public class ExprClearVisitor extends LabeledClearBaseVisitor<Integer> {

    Map<String, Integer> memory = new HashMap<>();

    @Override
    public Integer visitPrintExpr(LabeledClearParser.PrintExprContext ctx) {
        Integer value = visit(ctx.expr());
        System.out.println(value);
        return 0;
    }

    @Override
    public Integer visitAssign(LabeledClearParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Integer value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Integer visitClearMemory(LabeledClearParser.ClearMemoryContext ctx) {
        String id = ctx.ID().getText();
        Integer remove = memory.remove(id);
        System.out.printf("remove id : %s, value : %s", id, remove);
        System.out.println();
        return remove;
    }

    @Override
    public Integer visitMulDiv(LabeledClearParser.MulDivContext ctx) {
        Integer left = visit(ctx.expr(0));
        Integer right = visit(ctx.expr(1));
        if (ctx.op.getType() == LabeledClearParser.MUL) {
            return left * right;
        }
        return left / right;
    }

    @Override
    public Integer visitAddSub(LabeledClearParser.AddSubContext ctx) {
        Integer left = visit(ctx.expr(0));
        Integer right = visit(ctx.expr(1));
        if (ctx.op.getType() == LabeledClearParser.ADD) {
            return left + right;
        }
        return left - right;
    }

    @Override
    public Integer visitId(LabeledClearParser.IdContext ctx) {
        String id = ctx.ID().getText();
        return memory.getOrDefault(id, 0);
    }

    @Override
    public Integer visitInt(LabeledClearParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    @Override
    public Integer visitParents(LabeledClearParser.ParentsContext ctx) {
        return visit(ctx.expr());
    }
}
