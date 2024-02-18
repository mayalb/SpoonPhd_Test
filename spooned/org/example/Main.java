package org.example;
public class Main {
    public static void main(java.lang.String[] args) {
        // create a new spoon launcher
        spoon.Launcher launcher = new spoon.Launcher();
        // add the input java file to transform
        launcher.addInputResource("./src/main/java");
        // run the spoon
        launcher.run();
        // get the transformed model
        spoon.reflect.CtModel model = launcher.getModel();
        // transform and print the model
        java.util.List<spoon.reflect.declaration.CtClass> Classes = model.filterChildren(new spoon.reflect.visitor.filter.NamedElementFilter(spoon.reflect.declaration.CtClass.class, "XYDataItem")).list();
        spoon.reflect.declaration.CtClass inputCode = ((spoon.reflect.declaration.CtClass) (Classes.get(0)));
        java.lang.System.out.println("   ----- Input Code ---- \n\n" + inputCode);
        org.example.Reverse reverse = new org.example.Reverse();
        reverse.reverseOperators(inputCode);
        java.lang.System.out.println("   ----- transformed Code ---- \n\n");
        java.lang.System.out.println(inputCode);
    }
}