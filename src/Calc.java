import java.lang.reflect.Array;
import java.util.*;

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
                    System.out.println("Результат: " + (expression.plus()));
                    return;
                case '-':
                    System.out.println("Результат: " + (expression.minus()));
                    return;
                case '*':
                    System.out.println("Результат: " + (expression.multipli()));
                    return;
                case '/':
                    System.out.println("Результат: " + (expression.division()));
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
                    System.out.println("Результат: " + (RomanNumerals(expression.plus())));
                    return;
                case '-':
                    System.out.println("Результат: " + (RomanNumerals(expression.minus())));
                    return;
                case '*':
                    System.out.println("Результат: " + (RomanNumerals(expression.multipli())));
                    return;
                case '/':
                    double k = (double) expression.division();
                    if(k % 1 != 0)
                        System.out.println("Результат: " + (k));
                    else
                        System.out.println("Результат: " + (RomanNumerals((int) k)));
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

    public static String RomanNumerals(int Int) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){
            int matches = Int/entry.getValue();
            res += repeat(entry.getKey(), matches);
            Int = Int % entry.getValue();
        }
        return res;
    }
    public static String repeat(String s, int n) {
        if(s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
