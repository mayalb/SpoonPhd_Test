package org.example;
public class Reverse {
    public Reverse() {
    }

    public static void reverseOperators(spoon.reflect.declaration.CtClass<?> ctClass) {
        // Traverse through the elements of the CtClass
        for (spoon.reflect.declaration.CtElement element : ctClass.getElements(e -> true)) {
            // If the element is an if statement
            if (element instanceof spoon.reflect.code.CtIf) {
                spoon.reflect.code.CtIf ifStatement = ((spoon.reflect.code.CtIf) (element));
                // Reverse operators in the condition
                if (ifStatement.getCondition() instanceof spoon.reflect.code.CtBinaryOperator) {
                    spoon.reflect.code.CtBinaryOperator condition = ((spoon.reflect.code.CtBinaryOperator) (ifStatement.getCondition()));
                    condition.setKind(org.example.Reverse.reverseOperator(condition.getKind()));
                }
            }
        }
    }

    // Method to reverse operators
    public static spoon.reflect.code.BinaryOperatorKind reverseOperator(spoon.reflect.code.BinaryOperatorKind operator) {
        // Change the return type
        switch (operator) {
            case EQ :
                return spoon.reflect.code.BinaryOperatorKind.NE;
            case NE :
                return spoon.reflect.code.BinaryOperatorKind.EQ;
            case LT :
                return spoon.reflect.code.BinaryOperatorKind.GE;
            case LE :
                return spoon.reflect.code.BinaryOperatorKind.GT;
            case GT :
                return spoon.reflect.code.BinaryOperatorKind.LE;
            case GE :
                return spoon.reflect.code.BinaryOperatorKind.LT;
            case AND :
                return spoon.reflect.code.BinaryOperatorKind.OR;
            case OR :
                return spoon.reflect.code.BinaryOperatorKind.AND;
                // Add more cases for other operators as needed
            default :
                return operator;
        }
    }
}