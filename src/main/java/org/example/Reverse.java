package org.example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import spoon.Launcher;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;

import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.factory.Factory;
import spoon.reflect.visitor.DefaultJavaPrettyPrinter;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.BinaryOperatorKind;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import spoon.Launcher;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.factory.Factory;
import spoon.reflect.visitor.filter.TypeFilter;

public class Reverse {
    //public static void transformModel(CtModel model) {
        //model.getElements(new TypeFilter<>(CtIf.class)).forEach(ifStatement -> {
            //CtExpression<Boolean> condition = ((CtIf) ifStatement).getCondition();
          //  CtExpression<Boolean> transformedCondition = reverseBinaryOperators(condition);
        //    ((CtIf) ifStatement).setCondition(transformedCondition);
      //  });
    //}
    public static void reverseOperators(CtClass<?> ctClass) {
        // If the element is a class

        // Traverse through the elements of the CtClass
        for (CtElement element : ctClass.getElements(e -> true)) {
            // If the element is an if statement
            if (element instanceof CtIf) {
                CtIf ifStatement = (CtIf) element;

                reverseBinaryOperators(ifStatement.getCondition());

            }
        }
    }


    // Method to reverse binary operators recursively
    public static  void reverseBinaryOperators(CtExpression<?> expression) {
        if (expression instanceof CtBinaryOperator) {
            CtBinaryOperator<?> binaryOperator = (CtBinaryOperator<?>) expression;
            BinaryOperatorKind originalKind = binaryOperator.getKind();
            switch (originalKind) {
                case AND:
                    binaryOperator.setKind(BinaryOperatorKind.OR);
                    break;
                case OR:
                    binaryOperator.setKind(BinaryOperatorKind.AND);
                    break;
                // Handle comparison operators

                case EQ:
                case NE:
                case LT:
                case LE:
                case GT:
                case GE:
                    // Reverse comparison operators
                    reverseComparisonOperator(binaryOperator);
                    break;
                default:
                    break;
            }
            // Recursively process left and right operands
            reverseBinaryOperators(binaryOperator.getLeftHandOperand());
            reverseBinaryOperators(binaryOperator.getRightHandOperand());
        }
    }
    // Method to reverse comparison operators
    public static void reverseComparisonOperator(CtBinaryOperator<?> binaryOperator) {
        BinaryOperatorKind originalKind = binaryOperator.getKind();
        switch (originalKind) {
            case EQ:
                binaryOperator.setKind(BinaryOperatorKind.NE);
                break;
            case NE:
                binaryOperator.setKind(BinaryOperatorKind.EQ);
                break;
            case LT:
                binaryOperator.setKind(BinaryOperatorKind.GT);
                break;
            case LE:
                binaryOperator.setKind(BinaryOperatorKind.GE);
                break;
            case GT:
                binaryOperator.setKind(BinaryOperatorKind.LT);
                break;
            case GE:
                binaryOperator.setKind(BinaryOperatorKind.LE);
                break;
            default:
                break;
        }
    }

    public static CtExpression<Boolean> reverseOperators(CtExpression<Boolean> condition) {
        if (condition instanceof CtBinaryOperator) {
            CtBinaryOperator<Boolean> binaryOperator = (CtBinaryOperator<Boolean>) condition;
            switch (binaryOperator.getKind()) {
                case EQ:
                    return binaryOperator.clone().setKind(BinaryOperatorKind.NE);
                case NE:
                    return binaryOperator.clone().setKind(BinaryOperatorKind.EQ);
                case AND:
                    return binaryOperator.clone().setKind(BinaryOperatorKind.OR);
                case OR:
                    return binaryOperator.clone().setKind(BinaryOperatorKind.AND);
                case GT:
                    return binaryOperator.clone().setKind(BinaryOperatorKind.LT);
                case GE:
                    return binaryOperator.clone().setKind(BinaryOperatorKind.LE);
                case LT:
                    return binaryOperator.clone().setKind(BinaryOperatorKind.GT);
                case LE:
                    return binaryOperator.clone().setKind(BinaryOperatorKind.GE);
            }
        }
        return condition;
    }

}

