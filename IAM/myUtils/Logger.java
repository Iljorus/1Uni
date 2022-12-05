package myUtils;

import java.time.LocalTime;
import java.time.LocalDate;
import java.io.*;

public class Logger {
    private final String DEFAULT_PATH="./logs/";    //Edit this to your needs
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
     * @deprecated
     */
    public void reCreateLogger(){
        mkFile(this.fileOut.getName());
    }
    /** 
     * @param path Updates the path from the default location to the specified one
     * */ 
    public void setPath(String path){
        this.path=path;
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
        this.source=String.valueOf(this.getClass()).split(" ")[1];
        try {
            int i=1;
            File output=new File(this.path+name+"-"+i+".log");
            for(;!output.createNewFile();i++)output=new File(this.path+name+"-"+i+".log");
            if(output!=null){
                this.fileOut=output;
                log("Log created " + output.getName());
            }
            this.source=origin;
            return;
        }
        catch (IOException e) {
            console("An error occurred.");
            e.printStackTrace();
            this.fileOut=null;
            this.source=origin;
            return;
        }
    }
    /** 
     * Prints a {@code String} to the console
     * @param input An input String
     * @see file()
     * */  
    public void console(String x){
        x="["+getTime()+"] "+getSource(true)+x;
        System.out.println(x);
    }
    /** 
     * Prints a {@code String} to the file
     * @param input An input String
     * @see file
     * */ 
    public void file(String x){
        if(this.fileOut==null)return;
        x="["+getTime()+"] "+getSource(true)+x;
        try{
            BufferedWriter fWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOut, true), "UTF-8"));
            fWriter.append(x);
            fWriter.newLine();
            fWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Prints a {@code String} to both console and file
     * @param x {@code String} input
     */
    public void log(String x){
        console(x);
        file(x);
    }
    /**
     * Prints a {@code String} to file and to "System.out" without styling
     * @param x
     */
    public void logAndDefault(String x){
        System.out.println(x);
        file(x);
    }
    /**
     * 
     * @param c {@code Object} Class
     */
    public void setSource(Object c){
        this.source=String.valueOf(c.getClass()).split(" ")[1];
    }
    /**
     * @param c {@code Boolean} for cosmetic styling
     * @return {@code String} source
     */
    private String getSource(boolean c){
        if(c && this.source!=null){
            return "["+this.source+"]: ";
        }
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