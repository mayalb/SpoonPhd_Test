package org.example;
import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtElement;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Welcome to the test");
        //create a new spoon launcher
        Launcher launcher= new Launcher();
        //add the input java file to transform
        launcher.addInputResource("");
        //run the spoon
        launcher.run();


        //get the transformed model
        CtModel model= launcher.getModel();


        // Print the transformed code

    }
}