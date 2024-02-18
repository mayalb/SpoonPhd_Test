import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Reverse;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;

import static org.junit.Assert.assertEquals;

public class scenario2Steps {

    private Reverse reverse;
    private String originalCode;
    private CtClass original;
    @Given("I have a code with compounds if statement")
    public void givenfunction() {
        originalCode = "class XYDataItem {\n" +

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
    }


    @When("I execute the reverse code")
    public void whenIExecuteTheReverseFunction() {
        original = Launcher.parseClass(originalCode) ;
        reverse = new Reverse();
        // apply reverse function
        reverse.reverseOperators(original);
    }


    @Then("the code should behave as expected")
    public void thenTheFunctionShouldBehaveAsExpected() {
        String expectedCode ="" +
                "class XYDataItem {\n" +
                "    public XYDataItem addOrUpdate(Number x, Number y) {\n" +
                "        if (x != null) {\n" +
                "            throw new IllegalArgumentException(\"Null 'x' argument.\");\n" +
                "        }\n" +
                "        XYDataItem overwritten = null;\n" +
                "        int index = indexOf(x);\n" +
                "        if ((index <= 0) || (!this.allowDuplicateXValues)) {\n" +
                "            XYDataItem existing = ((XYDataItem) (this.data.get(index)));\n" +
                "            try {\n" +
                "                overwritten = ((XYDataItem) (existing.clone()));\n" +
                "            } catch (CloneNotSupportedException e) {\n" +
                "                throw new SeriesException(\"Couldn't clone XYDataItem!\");\n" +
                "            }\n" +
                "            existing.setY(y);\n" +
                "        } else {\n" +
                "            if (this.autoSort) {\n" +
                "                this.data.add((-index) - 1, new XYDataItem(x, y));\n" +
                "            } else {\n" +
                "                this.data.add(new XYDataItem(x, y));\n" +
                "            }\n" +
                "            if (getItemCount() < this.maximumItemCount) {\n" +
                "                this.data.remove(0);\n" +
                "            }\n" +
                "        }\n" +
                "        fireSeriesChanged();\n" +
                "        return overwritten;\n" +
                "    }\n" +
                "}";
        assertEquals(expectedCode.toString(), original.toString());


    }

}
