package com.harmoush.ds.stack;

import java.util.Stack;

public class ConvertInfixToPostfix {
    private static final String OPERATORS = "+-*/$";

    public static char[] run(String infix) {
        Stack<Character> ops = new Stack<>();
        char[] postfix = new char[infix.length()];
        int p = 0;
        for (char c : infix.toCharArray()) {
            if (isOperand(c)) {
                postfix[p] = c;
                p++;
            } else if (ops.isEmpty() || hasHigherPrecedenceThanStackTopOperator(c, ops.peek())) {
                ops.push(c);
            } else {
                while (!(ops.isEmpty() || hasHigherPrecedenceThanStackTopOperator(c, ops.peek()))) {
                    postfix[p] = ops.pop();
                    p++;
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {
            postfix[p] = ops.pop();
            p++;
        }
        return postfix;
    }

    public static char[] execute(String infix) {
        Stack<Character> ops = new Stack<>();
        char[] postfix = new char[infix.length()];
        int p = 0;
        for (char c : infix.toCharArray()) {
            if (isOperand(c)) {
                postfix[p] = c;
                p++;
                continue;
            }
            while (!ops.isEmpty() && precedent(ops.peek(), c)) {
                postfix[p] = ops.pop();
                p++;
            }
            ops.push(c);
        }
        while (!ops.isEmpty()) {
            postfix[p] = ops.pop();
            p++;
        }
        return postfix;
    }

    private static boolean precedent(char op1, char op2) {
        return getOperatorPrecedence(op1) >= getOperatorPrecedence(op2);
    }

    private static boolean hasHigherPrecedenceThanStackTopOperator(char currOp, char stackTopOp) {
        return getOperatorPrecedence(currOp) > getOperatorPrecedence(stackTopOp);
    }

    private static int getOperatorPrecedence(char currOp) {
        return switch (currOp) {
            case '+', '-' -> 1;
            case '/', '*' -> 2;
            case '$' -> 3;
            default -> 0;
        };
    }

    private static boolean isOperand(char ch) {
        return OPERATORS.chars().noneMatch((p) -> ch == p);
    }
}
