package org.example;

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

    public static CtClass reverseOperators(CtClass code) {
        Map<String, String> OperatorMap = new HashMap<String, String>() {
            {
                this.put("<", ">");
                this.put(">", "<");
                this.put("==", "!=");
                this.put("!=", "==");
                this.put("<=", ">=");
                this.put(">=", "<=");
                this.put("&&", "||");
                this.put("||", "&&");
            }
        };
        Factory factory = (new Launcher()).createFactory();
        List<CtIf> conditions = code.getElements(new TypeFilter(CtIf.class));
        Iterator var4 = conditions.iterator();

        while(var4.hasNext()) {
            CtIf con = (CtIf)var4.next();
            CtCodeSnippetExpression exp = factory.createCodeSnippetExpression(StringUtils.replaceEach(con.getCondition().toString(), (String[])OperatorMap.keySet().toArray(new String[0]), (String[])OperatorMap.values().toArray(new String[0])));
            con.setCondition(exp);
        }

        return code;
    }
}
