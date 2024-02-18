package Tests.unitTest;

import org.example.Reverse;
import org.junit.Assert;
import org.junit.Test;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;

public class unitTest2 {
    @Test
    public void SimpleIfStatementTest() {
        String inputCode = "class Input {\n" +

                "public void code() {\n" +
                " int x = 2;\n" +
                "int y = 5;\n" +
                "if (x > 0) {\n" +
                " System.out.println(\"first case\");\n" +
                "}\n" +
                "if (y <= 5) {\n" +
                " System.out.println(\"second case\");\n" +
                "}\n" +
                "}";

        String expectedCode = "class Input {\n" +

                "public void code() {\n" +
                " int x = 2;\n" +
                "int y = 5;\n" +
                "if (x < 0) {\n" +
                " System.out.println(\"first case\");\n" +
                "}\n" +
                "if (y >= 5) {\n" +
                " System.out.println(\"second case\");\n" +
                "}\n" +
                "}";
        //parce the string into classes
        CtClass expected = Launcher.parseClass(expectedCode) ;
        CtClass original = Launcher.parseClass(inputCode) ;
        // apply reverse function
        Reverse.reverseOperators(original);
        Assert.assertEquals(expected.toString(), original.toString());
    }
    @Test
    public void CompoundIfStatementTest() {
        String inputCode = "class Input {\n" +

                "public void CompoundIfStatement() {\n" +
                " int x = 2;\n" +
                "int y = 5;\n" +
                "if  x < 0 || y > 10) {\n" +
                " System.out.println(\"Compound if statement\");\n" +
                "}\n" +
                "}";

        String expectedCode = "class Input {\n" +

                "public void CompoundIfStatement() {\n" +
                " int x = 2;\n" +
                "int y = 5;\n" +
                "if  x > 0 && y < 10) {\n" +
                " System.out.println(\"Compound if statement\");\n" +
                "}\n" +
                "}";
        //parce the string into classes
        CtClass expected = Launcher.parseClass(expectedCode) ;
        CtClass original = Launcher.parseClass(inputCode) ;
        // apply reverse function
        Reverse.reverseOperators(original);
        Assert.assertEquals(expected.toString(), original.toString());
    }
    @Test
    public void   ComplexIfStatementTest() {
        String inputCode = "class Input {\n" +

                "public void ComplexIfStatement() {\n" +
                " int x = 0;\n" +
                " int y = 45;\n" +
                " int x = 8;\n" +
                "if ((x > 0 || y < 10) && z == 5) {\n" +
                " System.out.println(\"complex if statement\");\n" +
                "}\n" +
                "}";

        String expectedCode = "class Input {\n" +

                "public void ComplexIfStatement() {\n" +
                " int x = 0;\n" +
                " int y = 45;\n" +
                " int x = 8;\n" +
                "if ((x < 0 && y > 10) || z != 5) {\n" +
                " System.out.println(\"complex if statement\");\n" +
                "}\n" +
                "}";
        //parce the string into classes
        CtClass expected = Launcher.parseClass(expectedCode) ;
        CtClass original = Launcher.parseClass(inputCode) ;
        // apply reverse function
        Reverse.reverseOperators(original);
        Assert.assertEquals (expected.toString(), original.toString());
    }
}
