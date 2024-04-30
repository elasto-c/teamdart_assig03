package com.teamdart.assig03;

import com.github.javaparser.*;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.DotPrinter;
import java.io.*;

/**
 * Some code that uses JavaParser.
 */

public class AST_DOT_Spitter {
    public static void main( String[] args ) throws FileNotFoundException {

        // Parse the code to be inspect:
        CompilationUnit cu = StaticJavaParser.parse(new File("src/main/resources/Main.java"));

        // inspection code:
        DotPrinter printer = new DotPrinter(true);
        try (FileWriter fileWriter = new FileWriter("AST_outputs/ast.dot");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.print(printer.output(cu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
