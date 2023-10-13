package prac1;

import java.time.temporal.ValueRange;
import java.util.Scanner;
import java.lang.Math;
public class Prac1 {
    public static void main(String[] args) {
        //task1
        /*Scanner scanner = new Scanner(System.in);
        String printMyName = scanner.nextLine();
        int nameLength = printMyName.length();
        int boxWidth = nameLength;
        System.out.println("+" + "-".repeat(boxWidth) + "+");
        System.out.println("|" + printMyName + "|");
        System.out.println("+" + "-".repeat(boxWidth) + "+");
        scanner.close();*/

        //task2
        /*Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int area = (int) Math.pow(a,2);
        int perimeter = a*4;
        double diagonal = (a*Math.sqrt(2));
        System.out.println(area + " ," + perimeter + " ," + diagonal);*/

        //task3
        /*int x = 100;
        char[] g = {'F', 'F', 'F', 'F', 'F', 'D', 'D', 'C', 'B', 'A', 'A'};
        System.out.println("Grade: " + g[x / 10]);*/

        //task4
        /*Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        double xo,xt;
        double d = Math.pow(b,2) - (4*a*c);
        double d1 = Math.sqrt(d);
        if(d<0){System.out.println("error!");}
        else{
            xo = ((-b)+d1)/2*a;
            xt = ((-b)-d1)/2*a;
        }
        System.out.println("x1: " + xo);
        System.out.println("x2: " + xt);*/

        //task5
        /*Scanner scanner = new Scanner(System.in);
        int balance = scanner.nextInt();
        int percent = scanner.nextInt();
        int res = balance + (percent*balance/100);
        System.out.println(res);*/

        //task6
        /*Scanner scanner = new Scanner(System.in);
        String pal = scanner.nextLine();
        int length = pal.length();
        boolean isPalindrome = true;
        for (int i = 0, j = length - 1; i <= j; i++, j--) {
            if (pal.charAt(i) != pal.charAt(j)) {
                isPalindrome = false;
            }
        }
            if(isPalindrome == true){System.out.println("Palindrome");}
            else{System.out.println("Not Palindrome");}*/
    }
}