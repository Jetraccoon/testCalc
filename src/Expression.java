import java.util.LinkedHashMap;
import java.util.Map;

public class Expression {
    int number1;
    int number2;

    public Expression(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    int plus(){
        return number1+number2;
    }

    int minus(){
        return number1-number2;
    }

    int multipli(){
        return number1*number2;
    }

    double division(){
        return (double) number1/number2;
    }


}
