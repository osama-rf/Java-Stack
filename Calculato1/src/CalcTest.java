public class CalcTest {
    public static void main(String[] args){
        Calc calc = new Calc();
        calc.setOperandOne(10.5);
        calc.setOperation('+');
        calc.setOperandTwo(5.2);
        calc.performOperation();
        System.out.println(calc.getResult());
    }
}
