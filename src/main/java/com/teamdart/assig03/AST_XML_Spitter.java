package com.teamdart.assig03;
//package com.github.javaparser;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.XmlPrinter;

import java.io.*;
//import java.util.Scanner;

/**
 * Some code that uses JavaParser.
 */

public class AST_XML_Spitter {
    public static void main( String[] args ) throws FileNotFoundException {

        // Parse the code to be inspect:
        CompilationUnit cu = StaticJavaParser.parse(new File("src/main/resources/Main.java"));

        // inspection code:
        XmlPrinter printer = new XmlPrinter(true);
        try (FileWriter fileWriter = new FileWriter("AST_outputs/ast.xml");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.print(printer.output(cu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
