package myUtils;

public class Numbers {      //Mby rename 
    public Numbers(){
    }
    private String toDecimal(String x, int s){
        int result=0;
        String[] numArray=x.split("");
        for(int i=numArray.length-1;i>=0;i--)result+=Math.pow(s, i)*conChars(String.valueOf(numArray[(numArray.length-1)-i]));
        return String.valueOf(result);
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
    private String conNum(String x){
        if(x.equals("10"))return "A";
        else if(x.equals("11"))return "B";
        else if(x.equals("12"))return "C";
        else if(x.equals("13"))return "D";
        else if(x.equals("14"))return "E";
        else if(x.equals("15"))return "F";
        else return String.valueOf(x);
    }
    /**
     * Converts a number base {@code x} into base {@code y}
     * @param s {@code String} Number
     * @param x {@code int} Base of input
     * @param y {@code int} Base of output
     * @return {@code String} Converted number
     */
    public String convert(String s, int x, int y){
        if(y==16){
            String result="";
            int num=Integer.valueOf(toDecimal(s, x));
            for(int i=String.valueOf(num).length()-1;i>=0;i--){
                result+=conNum(String.valueOf(num%16));
                num/=16;
            }
            String[] copy=result.split("");
            String[] cache=new String[copy.length];
            for(int i=copy.length-1;i>=0;i--)cache[(copy.length-1)-i]=(cache[i].equals("0"))?"":copy[i];
            return String.join("",cache);
        }
        else{
            int result=0;
            String[] numArray=toDecimal(s, x).split("");
            for(int i=numArray.length-1;i>=0;i--)result+=(int)Math.pow(y, i)*Integer.valueOf(numArray[(numArray.length-1)-i]);
            return String.valueOf(result);
        }
    }
}