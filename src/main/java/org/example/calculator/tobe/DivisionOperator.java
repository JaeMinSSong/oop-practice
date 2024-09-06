package org.example.calculator.tobe;

import org.example.calculator.domain.PositiveNumber;

public class DivisionOperator implements ArithmeticOperator{
    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
//        if(operand2.toInt() == 0){
//            throw new IllegalArgumentException("0으로는 나눌 수 없습니다"); //PositiveNumber를 생성헀으므로 operand2에서 operand2.toInt()
//        }
//        이 부분은 PositiveNumber가 생성 된 후 validate에 의해 자동으로 양수임을 보장하므로 필요없어짐
        return operand1.toInt() / operand2.toInt();
    }
}
