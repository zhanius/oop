package labwork2.task5;

public class Resistor extends Circuit{
    private double resistance;
    private double potentialDifference;
    public Resistor(double resistance){
        this.resistance = resistance;
    }
    @Override
    public double getResistance(){
        return resistance;
    }
    public double getPotentialDifference(){
        return potentialDifference;
    }
    public void setPotentialDifference(double potentialDifference){
        this.potentialDifference = potentialDifference;
    }
    @Override
    public double getPotentialDiff(){
        return getPotentialDifference();
    }
    @Override
    public void applyPotentialDiff(double V){
        this.potentialDifference = V;
    }
}
