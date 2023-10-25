package prac5;

import java.util.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Example4 {
    public static void main(String[] args) {
        double leftOperand, result, rightOperand;
        String leftString, operator, rightString;

        StringTokenizer tokenizer;

        Scanner in = new Scanner(System.in);

        tokenizer = new StringTokenizer(in.nextLine(), "+", true);

        try {
            leftString = tokenizer.nextToken();
            operator = tokenizer.nextToken();
            rightString = tokenizer.nextToken();

            leftOperand = Double.parseDouble(leftString);
            rightOperand = Double.parseDouble(rightString);

            if (operator.equals("+"))
                result = leftOperand + rightOperand;
            else
                result = 0.0;

            System.out.println("Result: " + result);
        } catch (NoSuchElementException nsee) {
            System.out.println("Invalid syntax");
        } catch (NumberFormatException nfe) {
            System.out.println("One or more operands is not a number");
        }
    }
}
