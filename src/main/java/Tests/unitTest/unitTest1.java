package Tests.unitTest;

import org.junit.Test;
import org.junit.Assert;

import org.example.Reverse;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;


public class unitTest1 {
    @Test
    public void ReverseCodeTest() {
    String inputCode = "class XYDataItem {\n" +

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

    String expectedCode = "class XYDataItem{\n" +
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
    //parce the string into classes
    CtClass expected = Launcher.parseClass(expectedCode) ;
    CtClass original = Launcher.parseClass(inputCode) ;
    // apply reverse function
    Reverse.reverseOperators(original);
    Assert.assertEquals(expected.toString(), original.toString());
    }
}
