package myUtils;

public class Measurement{
    private long startTime=0;
    private long endTime=0;
    private Logger log;
    /**
     * This class provides tools to messure the processing time of the Program
     * @param log {@code Logger} to write to
     */
    public Measurement(Logger log){
        this.log=new Logger(String.valueOf(this.getClass()).split(" ")[1], log.getFile());
    }
    /** 
     * Starts the messurment
    */
    public void start(){
        this.startTime=System.currentTimeMillis();
        log.toFile("Messurment started");
    }
    /**
     * Ends the messurment
     * @return Messurment
     */
    public Measurement end(){
        this.endTime=System.currentTimeMillis();
        log.toFile("Messurment end");
        return this;
    }
    /** 
     * Calculates the time between {@code start} and {@code end}
    */
    public void result(){
        String result="Processing time ";
        if(this.endTime==0)result="The messurment hasn't ended yet";
        long difference=this.endTime-this.startTime;
        if(difference<1E3)result+=difference+" ms";
        else if(difference>=1E3 && difference<60E6)result+=difference*1E-3+" sec";
        else if(difference>=60E6 && difference<360E6)result+=difference*1E-6+" min";
        else result= "Processing took too long. FIX YOUR CODE!!";
        log.toFile(result);
    }
}