package org.example;
public class Reverse {
    // public static void transformModel(CtModel model) {
    // model.getElements(new TypeFilter<>(CtIf.class)).forEach(ifStatement -> {
    // CtExpression<Boolean> condition = ((CtIf) ifStatement).getCondition();
    // CtExpression<Boolean> transformedCondition = reverseBinaryOperators(condition);
    // ((CtIf) ifStatement).setCondition(transformedCondition);
    // });
    // }
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

    // print function
    public static void printAST(spoon.reflect.CtModel model, spoon.Launcher launcher) {
        spoon.reflect.visitor.DefaultJavaPrettyPrinter printer = new spoon.reflect.visitor.DefaultJavaPrettyPrinter(launcher.getEnvironment());
        model.getAllTypes().forEach(type -> {
            printer.scan(type);
            java.lang.System.out.println(printer.toString());
        });
    }

    // Method to reverse binary operators recursively
    // Method to reverse binary operators recursively
    private static void reverseBinaryOperators(spoon.reflect.code.CtExpression<?> expression) {
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
    private static void reverseComparisonOperator(spoon.reflect.code.CtBinaryOperator<?> binaryOperator) {
        spoon.reflect.code.BinaryOperatorKind originalKind = binaryOperator.getKind();
        switch (originalKind) {
            case EQ :
                binaryOperator.setKind(spoon.reflect.code.BinaryOperatorKind.NE);
                break;
            case NE :
                binaryOperator.setKind(spoon.reflect.code.BinaryOperatorKind.EQ);
                break;
            case LT :
                binaryOperator.setKind(spoon.reflect.code.BinaryOperatorKind.GE);
                break;
            case LE :
                binaryOperator.setKind(spoon.reflect.code.BinaryOperatorKind.GT);
                break;
            case GT :
                binaryOperator.setKind(spoon.reflect.code.BinaryOperatorKind.LE);
                break;
            case GE :
                binaryOperator.setKind(spoon.reflect.code.BinaryOperatorKind.LT);
                break;
            default :
                break;
        }
    }

    public static spoon.reflect.code.CtExpression<java.lang.Boolean> reverseOperators(spoon.reflect.code.CtExpression<java.lang.Boolean> condition) {
        if (condition instanceof spoon.reflect.code.CtBinaryOperator) {
            spoon.reflect.code.CtBinaryOperator<java.lang.Boolean> binaryOperator = ((spoon.reflect.code.CtBinaryOperator<java.lang.Boolean>) (condition));
            switch (binaryOperator.getKind()) {
                case EQ :
                    return binaryOperator.clone().setKind(spoon.reflect.code.BinaryOperatorKind.NE);
                case NE :
                    return binaryOperator.clone().setKind(spoon.reflect.code.BinaryOperatorKind.EQ);
                case AND :
                    return binaryOperator.clone().setKind(spoon.reflect.code.BinaryOperatorKind.OR);
                case OR :
                    return binaryOperator.clone().setKind(spoon.reflect.code.BinaryOperatorKind.AND);
                case GT :
                    return binaryOperator.clone().setKind(spoon.reflect.code.BinaryOperatorKind.LE);
                case GE :
                    return binaryOperator.clone().setKind(spoon.reflect.code.BinaryOperatorKind.LT);
                case LT :
                    return binaryOperator.clone().setKind(spoon.reflect.code.BinaryOperatorKind.GE);
                case LE :
                    return binaryOperator.clone().setKind(spoon.reflect.code.BinaryOperatorKind.GT);
            }
        }
        return condition;
    }
}