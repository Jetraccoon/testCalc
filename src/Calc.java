import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String[] expressionStr = in.nextLine().split(" ");
        ArrayList<String> romeNumbers = new ArrayList<>();
        romeNumbers.addAll(Arrays.asList("I","II","III","IV","V","VI","VII","VIII","IX","X"));

        if(expressionStr.length<3){
            System.out.println("Введено неправильное выражение!");
            return;
        }

        if(checkString(expressionStr[0]) == true && checkString(expressionStr[2]) == true){
            Expression expression = new Expression(Integer.parseInt(expressionStr[0]),Integer.parseInt(expressionStr[2]));
            switch (expressionStr[1].charAt(0)){
                case '+':
                    expression.plus();
                    return;
                case '-':
                    expression.minus();
                    return;
                case '*':
                    expression.multipli();
                    return;
                case '/':
                    expression.division();
                    return;
                default:
                    System.out.println("Неправильно задана операция!");
                    return;
            }
        }

        if(romeNumbers.contains(expressionStr[0]) == true && romeNumbers.contains(expressionStr[2]) == true){
            Expression expression = new Expression(romeNumbers.indexOf(expressionStr[0])+1,romeNumbers.indexOf(expressionStr[2])+1);
            switch (expressionStr[1].charAt(0)){
                case '+':
                    expression.plus();
                    return;
                case '-':
                    expression.minus();
                    return;
                case '*':
                    expression.multipli();
                    return;
                case '/':
                    expression.division();
                    return;
                default:
                    System.out.println("Неправильно задана операция!");
                    return;
            }
        }

        System.out.println("Неправильно задано выражение!");

    }

        public static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
