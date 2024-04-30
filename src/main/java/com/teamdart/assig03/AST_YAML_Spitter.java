package com.teamdart.assig03;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.YamlPrinter;
import java.io.*;

/**
 * Some code that uses JavaParser.
 */

public class AST_YAML_Spitter {
    public static void main( String[] args ) throws FileNotFoundException {

        // Parse the code to be inspect:
        CompilationUnit cu = StaticJavaParser.parse(new File("src/main/resources/Main.java"));

        // inspection code:
        YamlPrinter printer = new YamlPrinter(true);
        try (FileWriter fileWriter = new FileWriter("AST_outputs/ast.yaml");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.print(printer.output(cu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
