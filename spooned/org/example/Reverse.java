package org.example;
public class Reverse {
    public static void reverseOperators(spoon.reflect.declaration.CtClass<?> ctClass) {
        // If the element is a class
        // Traverse through the elements of the CtClass
        for (spoon.reflect.declaration.CtElement element : ctClass.getElements(e -> true)) {
            // If the element is an if statement
            if (element instanceof spoon.reflect.code.CtIf) {
                spoon.reflect.code.CtIf ifStatement = ((spoon.reflect.code.CtIf) (element));
                org.example.Reverse.reverseBinaryOperators(ifStatement.getCondition());
            }
        }
    }

    // Method to reverse binary operators recursively
    public static void reverseBinaryOperators(spoon.reflect.code.CtExpression<?> expression) {
        if (expression instanceof spoon.reflect.code.CtBinaryOperator) {
            spoon.reflect.code.CtBinaryOperator<?> binaryOperator = ((spoon.reflect.code.CtBinaryOperator<?>) (expression));
            spoon.reflect.code.BinaryOperatorKind originalKind = binaryOperator.getKind();
            switch (originalKind) {
                case AND :
                    binaryOperator.setKind(spoon.reflect.code.BinaryOperatorKind.OR);
                    break;
                case OR :
                    binaryOperator.setKind(spoon.reflect.code.BinaryOperatorKind.AND);
                    break;
                    // Handle comparison operators
                case EQ :
                case NE :
                case LT :
                case LE :
                case GT :
                case GE :
                    // Reverse comparison operators
                    org.example.Reverse.reverseComparisonOperator(binaryOperator);
                    break;
                default :
                    break;
            }
            // Recursively process left and right operands
            org.example.Reverse.reverseBinaryOperators(binaryOperator.getLeftHandOperand());
            org.example.Reverse.reverseBinaryOperators(binaryOperator.getRightHandOperand());
        }
    }

    // Method to reverse comparison operators
    public static void reverseComparisonOperator(spoon.reflect.code.CtBinaryOperator<?> binaryOperator) {
        spoon.reflect.code.BinaryOperatorKind originalKind = binaryOperator.getKind();
        switch (originalKind) {
            case EQ :
                binaryOperator.setKind(spoon.reflect.code.BinaryOperatorKind.NE);
                break;
            case NE :
                binaryOperator.setKind(spoon.reflect.code.BinaryOperatorKind.EQ);
                break;
            case LT :
                binaryOperator.setKind(spoon.reflect.code.BinaryOperatorKind.GT);
                break;
            case LE :
                binaryOperator.setKind(spoon.reflect.code.BinaryOperatorKind.GE);
                break;
            case GT :
                binaryOperator.setKind(spoon.reflect.code.BinaryOperatorKind.LT);
                break;
            case GE :
                binaryOperator.setKind(spoon.reflect.code.BinaryOperatorKind.LE);
                break;
            default :
                break;
        }
    }
}