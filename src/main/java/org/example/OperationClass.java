package org.example;

public class OperationClass {
    private String ifStatement;


    public void setIfStatement(String ifStatement) {
        this.ifStatement = ifStatement;
    }
    public boolean isPositiveAndLessThanTen(int x, int y) {
        return x > 0 && y < 10;
    }
}
