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
import spoon.reflect.visitor.filter.TypeFilter;
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
    public Reverse() {
    }

     public static void reverseOperators(CtClass<?> ctClass) {
        // Traverse through the elements of the CtClass
        for (CtElement element : ctClass.getElements(e -> true)) {
            // If the element is an if statement
            if (element instanceof CtIf) {
                CtIf ifStatement = (CtIf) element;

                // Reverse operators in the condition
                if (ifStatement.getCondition() instanceof CtBinaryOperator) {
                    CtBinaryOperator condition = (CtBinaryOperator) ifStatement.getCondition();
                    condition.setKind(reverseOperator(condition.getKind()));
                }
            }
        }
    }
    // Method to reverse operators
    public static BinaryOperatorKind reverseOperator(BinaryOperatorKind operator) { // Change the return type
        switch (operator) {
            case EQ:
                return BinaryOperatorKind.NE;
            case NE:
                return BinaryOperatorKind.EQ;
            case LT:
                return BinaryOperatorKind.GE;
            case LE:
                return BinaryOperatorKind.GT;
            case GT:
                return BinaryOperatorKind.LE;
            case GE:
                return BinaryOperatorKind.LT;
            case AND:
                return BinaryOperatorKind.OR;
            case OR:
                return BinaryOperatorKind.AND;
            // Add more cases for other operators as needed
            default:
                return operator;
        }
    }
}
