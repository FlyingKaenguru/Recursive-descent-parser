import java.util.Scanner;

public class Application {

/*
  simple calculator implemented via recursive descent

  <expr> := <expr> - <term>
            <expr> + <term>
            <term>
  <term> ::= <term> * <factor>
             <term> / <factor>
             <factor>
  <factor> ::= num
  <num>  := [0..9]
 */

    static int currentIndex = 0;
    static String result = "";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] input = s.next().toCharArray();

        System.out.println(expression(input, currentIndex));
    }

    private static String expression(char[] input, int i) {
        char x = addition(input, i);
        if (x != ' ') {
            result = Character.toString(x);
        }
        return result;
    }

    private static char addition(char[] input, int i) {
        var x = multiplication(input, i);                                                                     // 5
        char operator = expectToken(input, currentIndex);                                                           // +

        while (operator == '+' || operator == '-') {
            char y = multiplication(input, currentIndex + 1);                                                // i = 2

            if (x == ' ') {
                result += Character.toString(operator) + Character.toString(y);
            } else if (y == ' ') {
                result += Character.toString(operator) + Character.toString(x);
            } else {
                result += Character.toString(x) + Character.toString(operator) + Character.toString(y);
            }
            x = ' ';
            operator = expectToken(input, currentIndex);
        }
        return x;
    }


    private static char multiplication(char[] input, int i) {
        char x = atom(input, i);                                                                                    // 5 | 6

        char operator = expectToken(input, currentIndex);                                                           // + | *

        while (operator == '*' || operator == '/') {
            char y = atom(input, currentIndex + 1);
            if (x == ' ') {
                result += Character.toString(operator) + Character.toString(y);
            } else {
                result += Character.toString(x) + Character.toString(operator) + Character.toString(y);
            }
            x = ' ';
            operator = expectToken(input, currentIndex);
        }
        return x;
    }

    private static char atom(char[] input, int i) {
        char currentSymbol = expectToken(input, i);
        if (currentSymbol != ' ' && Character.isDigit(currentSymbol)) {
            currentIndex = (i + 1);                                                                           // 0 --> 1
            return input[i];                                                                                  // 5
        } else {
            return ' ';
        }
    }

    private static char expectToken(char[] input, int i) {
        if (currentIndex <= input.length - 1) {
            return input[i];
        } else {
            return ' ';
        }
    }
}
