public class Expression {
    int number1;
    int number2;

    public Expression(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    void plus(){
        System.out.println("Результат: " + (number1+number2));
    }

    void minus(){
        System.out.println("Результат: " + (number1-number2));
    }

    void multipli(){
        System.out.println("Результат: " + (number1*number2));
    }

    void division(){
        System.out.println("Результат: " + (number1/number2));
    }
}
