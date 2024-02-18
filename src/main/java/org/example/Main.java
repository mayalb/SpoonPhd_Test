package org.example;
import spoon.Launcher;
import spoon.reflect.CtModel;
import java.util.List;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.visitor.filter.NamedElementFilter;

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
        List<CtClass> Classes = model.filterChildren(new NamedElementFilter(CtClass.class, "XYDataItem")).list();
        CtClass inputCode = (CtClass)Classes.get(0);
        System.out.println("   ----- Input Code ---- \n\n" + inputCode);
        Reverse reverse= new Reverse();
        reverse.reverseOperators(inputCode);
       System.out.println("   ----- transformed Code ---- \n\n" );
       System.out.println(inputCode.toString());



    }



}