package com.company.restCalculatorService.Model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

public class Operands {

//    @Digits(integer = 1, fraction = 9999 )
//    @NotEmpty( message = "You must supply a number")
    private int operand1;
//    @NotEmpty( message = "You must supply a number")
    private int operand2;

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }
}
