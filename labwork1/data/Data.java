package labwork1.data;

import java.util.Scanner;

public class Data {
    private double sum;
    private double max;
    private int cnt;
    public Data() {
        sum = 0.0;
        max = Double.MIN_VALUE;
        cnt = 0;
    }
    public void addValue(double value) {
        sum += value;
        max = Math.max(value, max);
        cnt++;
    }
    public double getAverage() {
        if (cnt == 0) {
            return 0.0;
        } else {
            return sum / cnt;
        }
    }
    public double getMax() {
        return max;
    }
}
