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
     * @param s {@code String} source
     * */ 
    public Logger(String s){
        this.path=this.DEFAULT_PATH;
        this.source=s;
        mkFile(getDate());
    }
    /**
     * Creates the logger without creating a file to write to
     * @param s {@code String} source
     * @param file -> {@code false}
     */
    public Logger(String s, boolean file){
        this.source=s;
    }
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
        this.source="Logger.java";
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
            toConsole("An error occurred.");
            e.printStackTrace();
            this.fileOut=null;
            this.source=origin;
            return;
        }
    }
    /** 
     * Prints a {@code String} to the console
     * @param input An input String
     * @see toFile()
     * */  
    public void toConsole(String x){
        x="["+getTime()+"] "+getSource(true)+x;
        System.out.println(x);
    }
    /** 
     * Prints a {@code String} to the file
     * @param input An input String
     * @see toFile
     * */ 
    public void toFile(String x){
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
        toConsole(x);
        if(this.fileOut !=null)toFile(x);
    }
    /**
     * 
     * @param s {@code String} new Source
     */
    public void setSource(String s){
        this.source=s;
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