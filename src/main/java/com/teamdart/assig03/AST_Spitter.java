package com.teamdart.assig03;
//package com.github.javaparser;

import com.github.javaparser.*;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.DotPrinter;
/*
import com.github.javaparser.StaticJavaParser;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.utils.CodeGenerationUtils;
import com.github.javaparser.utils.Log;
import com.github.javaparser.utils.SourceRoot;
*/

import java.io.*;
//import java.util.Scanner;

/**
 * Some code that uses JavaParser.
 */

public class AST_Spitter {
    public static void main( String[] args ) throws FileNotFoundException {

        // Parse the code you want to inspect:
        CompilationUnit cu = StaticJavaParser.parse(new File("src/main/resources/Main.java"));
        // Now comes the inspection code:

        DotPrinter printer = new DotPrinter(true);
        try (FileWriter fileWriter = new FileWriter("ast.dot");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.print(printer.output(cu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(cu);
    }
}
