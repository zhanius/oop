package labwork3.problem4;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Vector;

public class Testim {
    public static void main(String[]args) throws CloneNotSupportedException{
        Employee erkin = new Employee("Erkin", "JR12", LocalDate.of(2020,12,12),1000.0);
        Employee askar = new Employee("Askar", "BR12", LocalDate.of(2019,12,12),1300.0);
        Employee lashyn = new Employee("Lashyn", "LR12", LocalDate.of(2019,10,11),1200.0);

        Employee lashyn1 = (Employee) lashyn.clone();
        System.out.println("Cloned: " + lashyn1);
        lashyn1.setHireDate(LocalDate.of(2023,12,12));
        System.out.println("Added new date to cloned one: " + lashyn1);
        System.out.println(lashyn);

        Manager kama = new Manager("Kamazhay", "KR12", LocalDate.of(2017,8,27), 2000.0);
        Manager uldino = new Manager("Uldana", "UR12", LocalDate.of(2017,7,25), 2000.0);
        kama.addTeammate(erkin);
        kama.addTeammate(askar);
        kama.addTeammate(lashyn);

        Vector<Employee>employees = new Vector<>();
        employees.add(erkin);
        employees.add(askar);
        employees.add(lashyn);
        employees.add(lashyn1);

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
