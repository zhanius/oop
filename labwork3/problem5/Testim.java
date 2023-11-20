package labwork3.problem5;
import prac2.Time;

public class Testim {
    public static void main(String[]args){
        Sort sort = new Sort();
        Chocolate [] chocolates = new Chocolate[5];
        Time [] times = new Time[5];

        chocolates[0] = new Chocolate("Kinder",100);
        chocolates[1] = new Chocolate("Bounty", 250);
        chocolates[2] = new Chocolate("Snickers", 50);
        chocolates[3] = new Chocolate("Milka", 200);
        chocolates[4] = new Chocolate("Mars", 50);

        times[0] = new Time(19, 12, 33);
        times[1] = new Time(22,22, 22);
        times[2] = new Time(21, 20, 45);
        times[3] = new Time(9, 45, 1);
        times[4] = new Time(12, 30, 59);

        System.out.println("Chocolates before sorting:");
        for (Chocolate chocolate : chocolates) {
            System.out.println(chocolate);
        }
        sort.heapSort(chocolates);
        System.out.println();
        System.out.println("Chocolates after sorting:");
        for (Chocolate chocolate : chocolates){
            System.out.println(chocolate);
        }
        System.out.println();
        System.out.println("Times before sorting:");
        for (Time time : times) {
            System.out.println(time);
        }
        sort.bubbleSort(times);
        System.out.println();
        System.out.println("Times after sorting:");
        for (Time time : times){
            System.out.println(time);
        }
    }
}
