package org.example;
import spoon.Launcher;
import spoon.reflect.CtModel;
import java.util.List;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.visitor.filter.NamedElementFilter;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.visitor.DefaultJavaPrettyPrinter;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.visitor.filter.NamedElementFilter;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //create a new spoon launcher
        Launcher launcher= new Launcher();
        //add the input java file to transform
        launcher.addInputResource("./src/main/java");
        //run the spoon
        launcher.run();


        //get the transformed model
        CtModel model= launcher.getModel();

        // transform and print the model
        List<CtClass> Classes = model.filterChildren(new NamedElementFilter(CtClass.class, "Input")).list();
        CtClass inputCode = (CtClass)Classes.get(0);



        System.out.println("   ----- Input Code ---- \n\n" + inputCode);
         Reverse.reverseOperators(inputCode);
        System.out.println(model);


        System.out.println(inputCode.toString());
        //System.out.println("\n \n   -----Transformed Code----- \n\n" + transformed);



    }



}