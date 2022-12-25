package myUtils;

public class Styling {
    
    public static String arrayToString(int[] x){
        String result="[";
        for(int i=0;i<x.length-1;i++)result+=String.valueOf(x[i])+" ";
        return result+String.valueOf(x[x.length-1])+"]";
    }
}
