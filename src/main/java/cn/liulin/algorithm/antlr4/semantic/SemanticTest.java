package cn.liulin.algorithm.antlr4.semantic;

import cn.liulin.algorithm.antlr4.expr.ExprTest;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * cn.liulin.algorithm.antlr4.semantic$
 *
 * @author ll
 * @date 2023-02-07 16:51:28
 **/
public class SemanticTest {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        sc.close();
        String path = SemanticTest.class.getResource("/cn/liulin/algorithm/antlr4/t.rows").getFile();
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
        RowsLexer lexer = new RowsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // 传递列号作为参数
        RowsParser parser = new RowsParser(tokens, i);
        // 不需要浪费时间建立语法分析树
        parser.setBuildParseTree(false);
        // 开始语法分析
        parser.file();

    }
}
