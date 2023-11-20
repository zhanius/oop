package labwork3.problem4;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Vector;

public class Testim {
    public static void main(String[]args) throws CloneNotSupportedException{
        Employee johnny = new Employee("Johnny", "JR12", LocalDate.of(2020,12,12),1000.0);
        Employee kitana = new Employee("Kitana", "BR12", LocalDate.of(2019,12,12),1300.0);
        Employee sub = new Employee("Subzero", "LR12", LocalDate.of(2019,10,11),1200.0);

        Employee sub1 = (Employee) sub.clone();
        System.out.println("Cloned: " + sub1);

        Manager kama = new Manager("Kamazhay", "KR12", LocalDate.of(2017,8,27), 2000.0);
        Manager uldino = new Manager("Uldana", "UR12", LocalDate.of(2017,7,25), 2000.0);
        kama.addTeammate(johnny);
        kama.addTeammate(kitana);
        kama.addTeammate(sub);

        Vector<Employee>employees = new Vector<>();
        employees.add(johnny);
        employees.add(kitana);
        employees.add(sub);
        employees.add(sub1);

        System.out.println("BEFORE SORTING:");
        employees.forEach(System.out::println);
        Collections.sort(employees);
        System.out.println("AFTER SORTING:");
        employees.forEach(System.out::println);

        System.out.println("\n\n\n");

        System.out.println("BEFORE SORTING BY DATE:");
        employees.forEach(System.out::println);
        Collections.sort(employees,new HireDateComparator());
        System.out.println("AFTER SORTING:");
        employees.forEach(System.out::println);

        System.out.println("\n\n\n");

        System.out.println("BEFORE SORTING BY NAME:");
        employees.forEach(System.out::println);
        Collections.sort(employees,new NameComparator());
        System.out.println("AFTER SORTING:");
        employees.forEach(System.out::println);
    }
}
