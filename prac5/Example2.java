package prac5;
public class Example2
{
    public static void main(String[] args)
    {
        //int i;
        int i = 0;
        int ratio;
        int[]      numbers = {100,10,0,5,2,8,0,30};

        for (i=0; i < numbers.length-1; i++) {
            try {
                // i = 0;
                ratio = numbers[i] / numbers[i + 1];
                System.out.println(numbers[i] + "/" + numbers[i + 1] + "=" + ratio);
            }
            catch (ArithmeticException ae){
                System.out.println("Couldn't calculate " + numbers[i] + "/" + numbers[i+1]);
            }
        }
    }
}


// 1 error - >  java: variable i might not have been initialized
// 2 error - >  java: variable i might not have been initialized
// fixed prob








