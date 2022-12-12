package myUtils.logger;

import java.time.LocalTime;

import java.time.LocalDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

//TODO only write full class path when error. (Do it like MC logs)
//If logging to console isn't needed anymore, rename methods to match InfoTypes
public class Logger {
    private final String DEFAULT_PATH="./logs/";
    private String path;
    private File fileOut;
    private String source;

    /** 
     * Creates the logger with the default path {@code ./logs/}
     * @param c {@code Object} Class
     * */ 
    public Logger(Object c){
        this.path=this.DEFAULT_PATH;
        setSource(c);
        mkFile(getDate());
    }

    /**
     * Creates the logger without creating a file
     * @param c {@code Object} Class
     * @param file -> {@code false}
     */
    public Logger(Object c, boolean file){
        setSource(c);
    }

    /**
     * Creats the logger with an already existing file
     * @param c {@code Object}
     * @param f {@code File}
     */
    public Logger(Object c, File f){
        setSource(c);
        this.fileOut=f;
    }

    /**
     * Creates a new file at the pre-determined path
     * @param name A name String
     * @return {@code File} object
     * 
     * @throws IOException  If an I/O error occurred
     */
    private void mkFile(String name){
        String origin=this.source;
        setSource(this);
        try {
            int i=1;
            File output=new File(this.path+name+"-"+i+".log");
            for(;!output.createNewFile();i++)output=new File(this.path+name+"-"+i+".log");
            if(output!=null){
                this.fileOut=output;
                logAndDefault("Log created " + output.getName(), InfoType.INFO);
            }
            this.source=origin;
            return;
        }
        catch(IOException ioE){
            console(ioE.getMessage(), InfoType.ERROR);
            this.fileOut=null;
            this.source=origin;
            return;
        }
    }

    /** 
     * Prints a {@code String} to the console
     * @param input An input String
     * */  
    public void console(String x, InfoType type){
        if(type.equals(InfoType.ERROR)){
            x="["+getTime()+"] ["+getSource()+"/"+type+"]: "+x;    
        }
        else {
            x="["+getTime()+"] ["+"Client"+"/"+type+"]: "+x;
        }
        System.out.println(x);
    }

    /** 
     * Prints a {@code String} to the file
     * @param input An input String
     * */ 
    public void file(Object x, InfoType type){
        try{
            String input=String.valueOf(x);
            if(this.fileOut==null)throw new FileNotFoundException("Cannot log to file, path is empty");
            if(type.equals(InfoType.ERROR)){
                input="["+getTime()+"] ["+getSource()+"/"+type+"]: "+input;
            }
            else{
                input="["+getTime()+"] ["+"Client"+"/"+type+"]: "+input;
            }
            
            BufferedWriter writer=createWriter();
            writer.append(input);
            writer.newLine();
            writer.close();
        }
        catch(IOException ioE){
            String origin=this.source;
            setSource(this);
            console(ioE.getMessage(), InfoType.ERROR);
            setSource(origin);
            return;
        }
    }

    /**
     * Prints a {@code String} to both console and file
     * @param x {@code String} input
     */
    public void log(String x, InfoType type){
        console(x, type);
        file(x, type);
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
            console(ioE.getMessage(), InfoType.ERROR);
            return null;
        }
    }

    /**
     * @param c {@code Object} Class
     */
    public void setSource(Object c){
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

    /**
     * @deprecated
     */
    public void reCreateLogger(){
        mkFile(this.fileOut.getName());
    }
}