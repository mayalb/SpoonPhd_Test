package Tests;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.example.* ;
import org.example.Reverse;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import static org.junit.Assert.assertEquals;
import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.Launcher;
import spoon.reflect.CtModel;
import java.util.List;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.visitor.filter.NamedElementFilter;

public class unitTest1 {
    @Test
    public void testCodeEquality() {
    String originalCode = "class A {\n" +

                "public XYDataItem addOrUpdate(Number x, Number y) {\n" +
                "if (x == null) {\n" +
                "throw new IllegalArgumentException(\"Null 'x' argument.\");\n" +
                "}\n" +
                "XYDataItem overwritten = null;\n" +
                "int index = indexOf(x);\n" +
                "if (index >= 0 && !this.allowDuplicateXValues) {\n" +
                "XYDataItem existing = (XYDataItem) this.data.get(index);\n" +
                "try {\n" +
                "overwritten = (XYDataItem) existing.clone();\n" +
                "}\n" +
                "catch (CloneNotSupportedException e) {\n" +
                "throw new SeriesException(\"Couldn't clone XYDataItem!\");\n" +
                "} \n" +
                "existing.setY(y);\n" +
                "}\n" +
                "else {\n" +
                "if (this.autoSort) {\n" +
                "this.data.add(-index - 1, new XYDataItem(x, y));\n" +
                "}\n" +
                "else {\n" +
                "this.data.add(new XYDataItem(x, y));\n" +
                "}\n" +
                "if (getItemCount() > this.maximumItemCount) {\n" +
                "this.data.remove(0);\n" +
                "}\n" +
                "}\n" +
                "fireSeriesChanged();\n" +
                "return overwritten;\n" +
                "}\n" +
                "}";

    String expectedCode = "class A{\n" +
                "public XYDataItem addOrUpdate(Number x, Number y) {\n" +
                "if (x != null) {\n" +
                "throw new IllegalArgumentException(\"Null 'x' argument.\");\n" +
                "}\n" +
                "XYDataItem overwritten = null;\n" +
                "int index = indexOf(x);\n" +
                "if (index <= 0 || !this.allowDuplicateXValues) {\n" +
                "XYDataItem existing = (XYDataItem) this.data.get(index);\n" +
                "try {\n" +
                "overwritten = (XYDataItem) existing.clone();\n" +
                "}\n" +
                "catch (CloneNotSupportedException e) {\n" +
                "throw new SeriesException(\"Couldn't clone XYDataItem!\");\n" +
                "}\n" +
                "existing.setY(y);\n" +
                "}\n" +
                "else {\n" +
                "if (this.autoSort) {\n" +
                "this.data.add(-index - 1, new XYDataItem(x, y));\n" +
                "}\n" +
                "else {\n" +
                "this.data.add(new XYDataItem(x, y));\n" +
                "}\n" +
                "if (getItemCount() < this.maximumItemCount) {\n" +
                "this.data.remove(0);\n" +
                "}\n" +
                "}\n" +
                "fireSeriesChanged();\n" +
                "return overwritten;\n" +
                "}\n" +
                "}";

    CtClass<?> expected = Launcher.parseClass(expectedCode) ;
    CtClass original = Launcher.parseClass(originalCode) ;
    //CtClass inputCode = (CtClass)Classes.get(0);
    Reverse.reverseOperators(original);
    //Reverse.reverseOperators(expectedCode);
    Assert.assertEquals(expected.toString(), expected.toString());
    }
}
