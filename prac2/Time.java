package prac2;

public class Time {
    public int hour;
    public int minute;
    public int second;

    public Time(int hour, int minute, int second) {
        if(hour>=0 && hour<=23 && minute>=0 && minute<=59 && second>=0 && second<=59){
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
        else{
            System.out.println("Invalid output");
        }
    }

    public String toUniversal() {
        return "Universal: " + ((this.hour < 10) ? "0" + this.hour : this.hour) + ":" + ((this.minute < 10) ? "0" + this.minute : this.minute) + ":"+ ((this.second < 10) ? "0" + this.second : this.second);
    }

    public String toStandard() {
        String format = (this.hour >= 12) ? "PM" : "AM";
        return "Standard: " + ((this.hour % 12 < 10) ? "0" + this.hour % 12 : this.hour % 12) + ":" + ((this.minute < 10) ? "0" + this.minute : this.minute) + ":"+ ((this.second < 10) ? "0" + this.second : this.second) + " " + format;
    }

    public void add(Time t) {
        int newSecond = (this.second + t.second);
        int newMinute = (this.minute + t.minute) + newSecond / 60;
        int newHour = (this.hour + t.hour) + newMinute / 60;
        this.second = newSecond%60;
        this.minute = newMinute%60;
        this.hour = newHour%24;
    }

    public static void main(String[] args) {

        Time t = new Time(23, 5, 6);
        System.out.println(t.toStandard());
        System.out.println(t.toUniversal());

        Time t2 = new Time(4, 24, 33);
        t.add(t2);
        System.out.println(t.toStandard());
        System.out.println(t.toUniversal());
    }
}
