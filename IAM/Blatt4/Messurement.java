//package messurement;

public class Messurement {
    private long startTime=0;
    private long endTime=0;
    public Messurement(){
    }
    public void start(){
        startTime=System.currentTimeMillis();
    }
    public void end(){
        endTime=System.currentTimeMillis();
    }
    public String result(){
        String result="";
        long difference=endTime-startTime;
        if(difference<1E3){
            result+=String.valueOf(difference);
            result+=" ms";
        }
        else if(difference>=1E3 && difference<1E6){
            result+=String.valueOf(difference*1E-3);
            result+=" sec";
        }
        else if(difference>=1E6 && difference<1E9){
            result+=String.valueOf(difference*1E-6);
            result+=" min";
        }
        else if(difference>=1E9 && difference<1E12){
            result+=String.valueOf(difference*1E-9);   
            result+=" h";
        }
        return result;
    }
}