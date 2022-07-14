public class Calc {
    private double OperandOne;
    private double OperandTwo;
    private char Operation;
    private double result;

    public Calc(){
    }

    public void setOperandOne(double operandOne) {
        OperandOne = operandOne;
    }

    public void setOperandTwo(double operandTwo) {
        OperandTwo = operandTwo;
    }

    public void setOperation(char operation) {
        Operation = operation;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public void performOperation(){
        if (Operation == '+'){
            result = OperandOne + OperandTwo;
        } else if (Operation == '-') {
            result = OperandOne - OperandTwo;
        } else if (Operation == '*') {
            result = OperandOne * OperandTwo;
        }else if (Operation == '/') {
            result = OperandOne / OperandTwo;
        } else {
            System.out.println("Null");
        }
    }
}