package cn.liulin.algorithm.antlr4.labeledexpr;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

/**
 * cn.liulin.algorithm.antlr4.labeledexpr$
 *
 * @author ll
 * @date 2023-02-07 14:32:16
 **/
public class LabeledTest {
    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        LabeledExprLexer lexer = new LabeledExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);
        ParseTree tree = parser.prog();
        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(tree);
    }
}
