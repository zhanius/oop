package prac2;

import java.util.Scanner;

public class StarTriangle {
    private int width;

    public StarTriangle(int width){
        this.width = width;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public String toString(){
        String ans = "";
        for(int i=0; i<width; i++){
            for(int j=0;j<width;j++){
                if(i>=j){String temp = ans + "[*]";
                    ans = temp;
                }
                else{
                    String temp = ans + " ";
                    ans = temp;}
            }
            String temp = ans + "\n";
            ans = temp;
        } return ans;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StarTriangle star = new StarTriangle(n);
        star.setWidth(n);
        System.out.println(star.toString());
    }
}
