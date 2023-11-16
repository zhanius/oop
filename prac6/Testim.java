package prac6;

public class Testim {
    public static void main(String[]args){
        Animal cat = new Cat("Murrrka");
        Person person = new Student("Adilbek");
        Person per = new Student("James Bond");

        Restaurant aroma = new Restaurant("Kabanbay Batyr", "Aroma");

        aroma.servePizza((CanHavePizza) cat);
        aroma.servePizza((CanHavePizza) per);
        person.eatPizza();
    }
}
