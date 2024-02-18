


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.OperationClass;
import org.example.*;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import static org.junit.Assert.assertEquals;




public class Steps {
    private OperationClass OperationInstance;
    private Reverse reverse;
    private String transformedCode;
    private String originalCode;
    private CtClass original;
    @Given("a Java code with an IF statement containing an AND operator")
    public void givenJavaCodeWithAndOperator() {
        originalCode = "class Input {\n" +
                "public void CompoundIfStatement() {\n" +
                "int x = 2;\n" +
                "int y = 5;\n" +
                "if  ((x < 0) && (y > 10)) {\n" +
                "System.out.println(\"Compound if statement\");\n" +
                "}\n" +
                "}";
        OperationInstance = new OperationClass();
    }




    @When("the reverse operators function is applied")
    public void whenReverseOperatorsFunctionApplied() {
        //  CtClass expected = Launcher.parseClass(expectedCode) ;
        original = Launcher.parseClass(originalCode) ;
        reverse = new Reverse();
        // apply reverse function
        reverse.reverseOperators(original);
    }


    @Then("the AND operator should be replaced with an OR operator")
    public void thenAndOperatorReplacedWithOr() {
        // Verify that the AND operator is replaced with OR
        String expectedCode ="" +
        "class Input {\n" +
        "    public void CompoundIfStatement() {\n" +
        "        int x = 2;\n" +
        "        int y = 5;\n" +
        "        if ((x > 0) || (y < 10)) {\n" +
        "            System.out.println(\"Compound if statement\");\n" +
        "        }\n" +
        "    }\n" +
        "}";
        System.out.println(original.toString());
        assertEquals(expectedCode.toString(), original.toString());


    }

}
