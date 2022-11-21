package myUtils;

public class Messurement{
    private long startTime=0;
    private long endTime=0;
    public Messurement(){}
    public void start(){
        this.startTime=System.currentTimeMillis();
    }
    public void end(){
        this.endTime=System.currentTimeMillis();
    }
    public String result(){
        long difference=this.endTime-this.startTime;
        if(difference<1E3)return difference+" ms";
        else if(difference>=1E3 && difference<60E6)return difference*1E3+" sec";
        else if(difference>=60E6 && difference<360E6)return difference*1E6+" min";
        else return "Fix your code";
    }
}