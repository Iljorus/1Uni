package myUtils;

public class Messurement{
    private long startTime=0;
    private long endTime=0;
    private Logger log;
    public Messurement(){
        this.log=new Logger();
    }
    public void start(){
        this.startTime=System.currentTimeMillis();
        log.toConsole("Messurment started");
    }
    public void end(){
        this.endTime=System.currentTimeMillis();
        log.toConsole("Messurment end");
    }
    public String result(){
        long difference=this.endTime-this.startTime;
        if(difference<1E3)return difference+" ms";
        else if(difference>=1E3 && difference<60E6)return difference*1E3+" sec";
        else if(difference>=60E6 && difference<360E6)return difference*1E6+" min";
        else return "Fix your code";
    }
    public void print(String x){
       log.toConsole("Process finished in "+x);
    }
}