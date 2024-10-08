package org.example.calculator.domain;


import org.example.calculator.tobe.AdditionOperator;
import org.example.calculator.tobe.ArithmeticOperator;
import org.example.calculator.tobe.DivisionOperator;

import java.util.List;

public class Calculator {
    private static final List<ArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new DivisionOperator());

    public static int calculate(PositiveNumber num1, String operator, PositiveNumber num2) {
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(num1, num2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }

    public static int calculate(int operand1, String operator, int operand2) {
//        if("+".equals(operator)) {
//            return operand1 + operand2;
//        }else if("-".equals(operator)) {
//            return operand1 - operand2;
//        }else if("*".equals(operator)) {
//            return operand1 * operand2;
//        }else if("/".equals(operator)) {
//            return operand1 / operand2;
//        }
//        return 0;
//    }
        return org.example.calculator.domain.ArithmeticOperator.calculate(operand1,operator,operand2);
    }
}
