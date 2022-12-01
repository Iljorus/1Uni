package myUtils;

public class Numbers {      //Mby rename
    private final String NUMERALS="0123456789ABCDEF";
    public Numbers(){
    }
    private String toDecimal(String x, int s){
        int result=0;
        String[] numArray=x.split("");
        for(int i=numArray.length-1;i>=0;i--)result+=Math.pow(s, i)*hexValue(String.valueOf(numArray[(numArray.length-1)-i]));
        return String.valueOf(result);
    }
    private boolean isHexChar(String s){
        return s.matches("[A-F]");
    }
    private boolean isNumeral(String s){
        return s.matches("[0-9]");
    }
    private int hexValue(String x){
        return NUMERALS.indexOf(x);
    }
    private String toHex(String x){
        return String.valueOf(NUMERALS.charAt(Integer.valueOf(x)));
    }
    /**
     * Converts a number base {@code x} into base {@code y}
     * @param s {@code String} Number
     * @param x {@code int} Base of input
     * @param y {@code int} Base of output
     * @return {@code String} Converted number
     */
    public String convert(String s, int x, int y){
        if(!isValid(s, x) || x==0 || y==0)return "error invalid input";
        String result="";
        int num=Integer.valueOf(toDecimal(s, x));
        while(num>0){
            result+=toHex(String.valueOf(num%y));
            num/=y;
        }
        String[] copy=result.split("");
        String[] cache=new String[copy.length];
        boolean deleteZero=true;
        for(int i=copy.length-1;i>=0;i--){
            if(deleteZero & copy[i].equals("0"))cache[(copy.length-1)-i]="";
            else {
                deleteZero=false;
                cache[(copy.length-1)-i]=copy[i];
            }
        }
        return String.join("",cache)+" :B"+y;
    }
    private boolean isValid(String s, int x){
        if(x<1 || s.equals("null"))return false;
        String[] numArray=s.split("");
        if(x==16){
            for(String str:numArray)if(!isNumeral(str) && !isHexChar(str))return false;
        }
        else {
            for(String str:numArray)if(isHexChar(str) || !str.matches("[0-"+String.valueOf(x-1)+"]"))return false;
        }
        return true;
    }
}