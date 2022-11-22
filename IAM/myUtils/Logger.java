package myUtils;

import java.time.LocalTime;
import java.time.LocalDate;
import java.io.*;

public class Logger {
    private final String DEFAULT_PATH="./logs/";
    private String path;
    private File fileOut;

    public Logger(){
        this.path=this.DEFAULT_PATH;
        this.fileOut=mkFile(getDate());
    }
    public void reCreateLogger(){
        this.fileOut=mkFile(this.fileOut.getName());
    }
    public void setPath(String path){
        this.path=path;
    }
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

    public void toConsole(String input){
        input="["+getTime()+"]: "+input;
        System.out.println(input);
    }
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
    private String getTime(){
        int h=LocalTime.now().getHour();
        int m=LocalTime.now().getMinute();
        int s=LocalTime.now().getSecond();
        return ((h<10)? "0"+h:""+h)+":"+((m<10)? "0"+m:""+m)+":"+((s<10)? "0"+s:""+s);
    }
    private String getDate(){
        return LocalDate.now().toString();
    }
}
