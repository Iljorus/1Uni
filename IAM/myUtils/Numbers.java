package myUtils;

public class Numbers {
    public Numbers(){

    }
    public int toDecimal(String x, int s){
        int result=0;
        String[] numArray=x.split("");
        int length=numArray.length;
        int[] input=new int[length];
        for(int i=0;i<numArray.length;i++){
            input[i]=conChars(numArray[i]);
        }
        for(int i=length-1;i>=0;i--){
            result+=Math.pow(s, i)*input[(length-1)-i];
        }
        return result;
    }
    private int conChars(String x){
        if(x.equalsIgnoreCase("A"))return 10;
        else if(x.equalsIgnoreCase("B"))return 11;
        else if(x.equalsIgnoreCase("C"))return 12;
        else if(x.equalsIgnoreCase("D"))return 13;
        else if(x.equalsIgnoreCase("E"))return 14;
        else if(x.equalsIgnoreCase("F"))return 15;
        else return Integer.valueOf(x);
    }
}
