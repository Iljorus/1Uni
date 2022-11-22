package myUtils;

import java.time.LocalTime;
import java.time.LocalDate;
import java.io.*;

public class Logger {
    private final String DEFAULT_PATH="./logs/";
    private String path;
    private File fileOut;
    /** 
     * Creates the logger with the default path './logs/'
     * */ 
    public Logger(){
        this.path=this.DEFAULT_PATH;
        this.fileOut=mkFile(getDate());
    }
    public void reCreateLogger(){
        this.fileOut=mkFile(this.fileOut.getName());
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
    private File mkFile(String name){
        try {
            int i=1;
            File output=new File(this.path+name+"-"+i+".log");
            for(;!output.createNewFile();i++)output=new File(this.path+name+"-"+i+".log");
            toConsole("Log created " + output.getName());
            return output;
        }
        catch (IOException e) {
            toConsole("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /** 
     * Prints a {@code String} to the console}
     * @param input An input String
     * @see toFile()
     * */  
    public void toConsole(String input){
        input="["+getTime()+"]: "+input;
        System.out.println(input);
    }
    /** 
     * Prints a {@code String} to the file
     * @param input An input String
     * @see toFile
     * */ 
    public void toFile(String input){
        input="["+getTime()+"]: "+input;
        try{
            BufferedWriter fWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOut, true), "UTF-8"));
            fWriter.append(input);
            fWriter.newLine();
            fWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
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
