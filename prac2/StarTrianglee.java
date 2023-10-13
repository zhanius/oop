package prac2;
public class StarTrianglee {
    private int width;
    private Condition cond;
    public StarTrianglee(int width,Condition cond){
        this.width = width;
        this.cond=cond;
    }
    public void setCondition(Condition cond) {
        this.cond = cond;
    }
    public String toString(){
        String str = "";
        if(cond == Condition.LEFT){
            for(int i=0; i<width; i++){
                for(int j=0; j<width; j++){
                    if(i>=j){
                        str += "[*]";
                    }
                }
                str += "\n";
            }
        }
        if(cond == Condition.RIGHT){
            for(int i=0; i<width; i++){
                for(int j=0; j<width; j++){
                    if(j < width-i-1){
                        str += "   ";
                    }
                    else{
                        str+= "[*]";
                    }
                }
                str += "\n";
            }
        }
        if(cond == Condition.MIDDLE) {
            int star = 1;
            if (width == 1) {
                str += "[*]";
            }
            for (int i = width; i >= 1; i--) {
                for (int space=i-1; space>=1;space--){
                    str+="   ";
                }
                for( int k=1;k<=star;k++){
                    str+="[*]";
                }
                str+="\n";
                star+=2;
            }
        }
        return str;
    }
    public static void main(String[]args){
        StarTrianglee s = new StarTrianglee(3,Condition.MIDDLE);
        StarTrianglee s1 = new StarTrianglee(3, Condition.RIGHT);
        StarTrianglee s2 = new StarTrianglee(3, Condition.LEFT);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);

    }
}