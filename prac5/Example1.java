package prac5;

public class Example1{

    public static void main(String[] args){
        int denominator, numerator, ratio;
        numerator = 5;
        denominator = 0; // denominator = 2;
        //ratio = numerator / denominator;
        //System.out.println("The answer is: "+ratio);
        //System.out.println("Done."); // Don't move this line

        try{
            System.out.println("Divide by 0.");
            ratio = numerator / denominator;
            System.out.println("The answer is: " + ratio);
            System.out.println("Done."); // Don't move this line
        }
        catch(ArithmeticException e){ // Why e? -> exception значениеси осыган присваиваться етип кетеди
            System.out.println("An exception occured: " + e.getMessage());
            e.printStackTrace(); //     What output was generated? -> method provides information about exception (0.0)
        }
    }

}

/*
Change the value of denominator to 0.
Re-compile and re-execute Example1.

What "error" was generated by the application when you executed it? ---> ArithmeticException

Why was this "error" generated at run-time (rather than at compile-time)?
because the code itself is correct, but the arithmetic execution is incorrect
*/