package org.example;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
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
        org.example.Reverse.reverseOperators(inputCode);
        java.lang.System.out.println("   ----- transformed Code ---- \n\n");
        java.lang.System.out.println(inputCode.toString());
        // System.out.println("\n \n   -----Transformed Code----- \n\n" + transformed);
        // String path_to_code = "./src/main/java/org/example/Input.java";
        // Reverse reverse = new Reverse();
        // Launcher launcher = new Launcher();
        // launcher.addInputResource(path_to_code);
        // launcher.buildModel();
        // CtModel model = launcher.getModel();
        // reverse.reverseOperators(model);
        // reverse.printAST(model,launcher);
    }
}