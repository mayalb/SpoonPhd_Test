package Tests.unitTest;
public class unitTest0 {
    @org.junit.Test
    public void SimpleIfStatementTest() {
        java.lang.String inputCode = ((((((((("class Input {\n" + "public void code() {\n") + " int x = 2;\n") + "int y = 5;\n") + "if (x > 0) {\n") + " System.out.println(\"first case\");\n") + "}\n") + "if (y <= 5) {\n") + " System.out.println(\"second case\");\n") + "}\n") + "}";
        java.lang.String expectedCode = ((((((((("class Input {\n" + "public void code() {\n") + " int x = 2;\n") + "int y = 5;\n") + "if (x < 0) {\n") + " System.out.println(\"first case\");\n") + "}\n") + "if (y >= 5) {\n") + " System.out.println(\"second case\");\n") + "}\n") + "}";
        // parce the string into classes
        spoon.reflect.declaration.CtClass expected = spoon.Launcher.parseClass(expectedCode);
        spoon.reflect.declaration.CtClass original = spoon.Launcher.parseClass(inputCode);
        // apply reverse function
        org.example.Reverse.reverseOperators(original);
        org.junit.Assert.assertEquals(expected.toString(), original.toString());
    }

    @org.junit.Test
    public void CompoundIfStatementTest() {
        java.lang.String inputCode = (((((("class Input {\n" + "public void CompoundIfStatement() {\n") + " int x = 2;\n") + "int y = 5;\n") + "if  x < 0 || y > 10) {\n") + " System.out.println(\"Compound if statement\");\n") + "}\n") + "}";
        java.lang.String expectedCode = (((((("class Input {\n" + "public void CompoundIfStatement() {\n") + " int x = 2;\n") + "int y = 5;\n") + "if  x > 0 && y < 10) {\n") + " System.out.println(\"Compound if statement\");\n") + "}\n") + "}";
        // parce the string into classes
        spoon.reflect.declaration.CtClass expected = spoon.Launcher.parseClass(expectedCode);
        spoon.reflect.declaration.CtClass original = spoon.Launcher.parseClass(inputCode);
        // apply reverse function
        org.example.Reverse.reverseOperators(original);
        org.junit.Assert.assertEquals(expected.toString(), original.toString());
    }

    @org.junit.Test
    public void ComplexIfStatementTest() {
        java.lang.String inputCode = ((((((("class Input {\n" + "public void ComplexIfStatement() {\n") + " int x = 0;\n") + " int y = 45;\n") + " int x = 8;\n") + "if ((x > 0 || y < 10) && z == 5) {\n") + " System.out.println(\"complex if statement\");\n") + "}\n") + "}";
        java.lang.String expectedCode = ((((((("class Input {\n" + "public void ComplexIfStatement() {\n") + " int x = 0;\n") + " int y = 45;\n") + " int x = 8;\n") + "if ((x < 0 && y > 10) || z != 5) {\n") + " System.out.println(\"complex if statement\");\n") + "}\n") + "}";
        // parce the string into classes
        spoon.reflect.declaration.CtClass expected = spoon.Launcher.parseClass(expectedCode);
        spoon.reflect.declaration.CtClass original = spoon.Launcher.parseClass(inputCode);
        // apply reverse function
        org.example.Reverse.reverseOperators(original);
        org.junit.Assert.assertEquals(expected.toString(), original.toString());
    }
}