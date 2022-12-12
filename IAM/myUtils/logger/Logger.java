package myUtils.logger;

import java.time.LocalTime;
import java.time.LocalDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

//only write full class path when error. (Do it like MC logs)
//If logging to console isn't needed anymore, rename methods to match InfoTypes cringe
//Not every log is a client log haha
public class Logger implements Runnable{
    private final String DEFAULT_PATH="./logs/";
    private String path;
    private File fileOut;
    private String source;
    private BufferedWriter writer;
    private volatile boolean running=true;

    /**
     * Starts the logger
     */
    public void run(){
        System.out.println("Running");
        while(running){
        }
    }

    /**
     * Stops the logger and closes the writer
     */
    public void halt(){
        running=false;
        try{
            writer.close();
        }catch(IOException ioE){
            System.out.println(ioE.getMessage());
        }
    }

    /** 
     * Creates the logger with the default path {@code ./logs/}
     * @param c {@code Object} Class
     * */ 
    public Logger(Object c){
        path=DEFAULT_PATH;
        setSource(c);
        if(!mkFile(getDate())){
            return;
        }
        writer=createWriter();
        logAndDefault("Log created " + fileOut.getName(), InfoType.INFO);
    }

    /**
     * Creats the logger with an already existing file
     * @param c {@code Object}
     * @param f {@code File}
     */
    public Logger(Object c, File f){
        setSource(c);
        this.fileOut=f;
        writer=createWriter();
    }

    /**
     * Creates a new file at the pre-determined path
     * @param name A name String
     * @return {@code File} object
     * 
     * @throws IOException  If an I/O error occurred
     */
    private boolean mkFile(String name){
        try {
            File output=new File(this.path+name+"-1.log");
            for(int i=2;!output.createNewFile();i++){
                output=new File(this.path+name+"-"+i+".log");
            }
            this.fileOut=output;
            return true;
        }
        catch(IOException ioE){
            String origin=this.source;
            setSource(this);
            //console("Cannot create file", InfoType.ERROR);
            System.out.println(ioE.getMessage());
            this.fileOut=null;
            this.source=origin;
            return false;
        }
    }

    /** 
     * Prints a {@code String} to the console
     * @param input An input String
     * */  
    public String style(String x, InfoType type){
        if(type.equals(InfoType.ERROR)){
            x="["+getTime()+"] ["+getSource()+"/"+type+"]: "+x;    
        }
        else {
            x="["+getTime()+"] ["+"Client"+"/"+type+"]: "+x;
        }
        return x;
    }

    /** 
     * Prints a {@code String} to the file
     * @param input An input String
     * */ 
    public void file(Object x, InfoType type){
        try{
            String input=String.valueOf(x);
            if(this.fileOut==null)throw new FileNotFoundException("Cannot log to file, path is empty");
            input=style(input, type);
            
            writer.append(input);
            writer.newLine();
            writer.flush();
        }
        catch(IOException ioE){
            String origin=this.source;
            setSource(this);
            System.out.println(ioE.getMessage());
            setSource(origin);
            return;
        }
    }

    /**
     * Prints a {@code String} to file and to "System.out" without styling
     * @param x
     */
    public void logAndDefault(String x, InfoType type){
        System.out.println(x);
        file(x, type);
    }

    private BufferedWriter createWriter(){
        try{
            return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOut, true), "UTF-8"));
        }
        catch(IOException ioE){
            System.out.println(ioE.getMessage());
            return null;
        }
    }

    /**
     * @param c {@code Object} Class
     */
    private void setSource(Object c){
        this.source=String.valueOf(c.getClass()).split(" ")[1];
    }

    /**
     * @return {@code String} source
     */
    private String getSource(){
        return this.source;
    }

    /**
     * @return {@code File} of this logger
     */
    public File getFile(){
        return this.fileOut;
    }

    /**
     * Fetches the current time
     * @return {@code String} HH:mm:ss
     */
    private String getTime(){
        int h=LocalTime.now().getHour();
        int m=LocalTime.now().getMinute();
        int s=LocalTime.now().getSecond();
        return ((h<10)? "0"+h:""+h)+":"+((m<10)? "0"+m:""+m)+":"+((s<10)? "0"+s:""+s);
    }

    /**
     * Fetches the current date
     * @return {@code String} YYYY-MM-DD
     */
    private String getDate(){
        return LocalDate.now().toString();
    }
}