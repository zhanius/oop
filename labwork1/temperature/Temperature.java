package labwork1.temperature;

public class Temperature {
    private double value;
    private char character;
    public Temperature() {
        this(0.0,'C');
    }
    public Temperature (double value){
        this.value = value;
        this.character = 'C';
    }
    public Temperature(char character){
        this.character = character;
        this.value = 0.0;
    }
    public Temperature(double value, char character){
        this.value = value;
        this.character = character;
    }
    public void setValue(double value){
        this.value = value;
    }
    public void setCharacter(char character){
        this.character = character;
    }
    public double getValue() {
        if (character == 'C') {
            return 5 * (value - 32) / 9;
        } else if (character == 'F')
            return 9 * (value / 5) + 32;
        else {
            return 0;
        }
    }
    public char getCharacter(){
        return character;
    }

    public String toString(){
        return "The temperature is: " + this.value + ", its schale is: " + this.character;
    }
    public static void main(String[]args){
        Temperature temp = new Temperature('F');
        Temperature temp1 = new Temperature();
        Temperature temp2 = new Temperature(12);
        Temperature temp3 = new Temperature(87, 'F');
        System.out.println(temp);
        System.out.println(temp1);
        System.out.println(temp2);
        System.out.println(temp3);
    }

}
