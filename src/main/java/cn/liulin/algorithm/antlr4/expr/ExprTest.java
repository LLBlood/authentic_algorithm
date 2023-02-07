package cn.liulin.algorithm.antlr4.expr;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.net.URL;

/**
 * cn.liulin.algorithm.antlr4.expr$
 *
 * @author ll
 * @date 2023-02-07 11:22:46
 **/
public class ExprTest {
    public static void main(String[] args) throws Exception {
        String path = ExprTest.class.getResource("/cn/liulin/algorithm/antlr4/t.expr").getFile();
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.prog();
        System.out.println(tree.toStringTree(parser));
    }
}
