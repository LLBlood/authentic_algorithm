package cn.liulin.algorithm.antlr4.labeledclear;

import cn.liulin.algorithm.antlr4.labeledexpr.LabeledExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * cn.liulin.algorithm.antlr4.labeledclear$
 *
 * @author ll
 * @date 2023-02-07 15:00:20
 **/
public class LabeledClearTest {
    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        LabeledClearLexer lexer = new LabeledClearLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledClearParser parser = new LabeledClearParser(tokens);
        ParseTree tree = parser.prog();
        ExprClearVisitor visitor = new ExprClearVisitor();
        visitor.visit(tree);
    }
}
