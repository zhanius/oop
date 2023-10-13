package labwork1.data;

import labwork1.data.Data;

import java.util.Scanner;

public class Analyzer {
        public static void main(String[] args) {
            Data d = new Data();

            Scanner s = new Scanner(System.in);

            System.out.println("Enter number (Q to quit): ");

            while(s.hasNext()) {
                if (s.hasNextDouble()) {
                    double num = s.nextDouble();
                    d.addValue(num);
                } else {
                    String val = s.next();
                    if (val.equalsIgnoreCase("Q")) {
                        break;
                    } else {
                        System.out.println("Invalid input");
                    }
                }
            }

            System.out.println("Average = " + d.getAverage());
            System.out.println("Maximum = " + d.getMax());
            s.close();
        }
}
