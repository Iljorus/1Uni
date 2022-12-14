package myUtils.time;

import java.time.LocalTime;

public class Clock extends Thread{
    private volatile boolean running=true;
    private volatile Time time;
    public Clock(){
        time=fetchTime();
    }
    public void run(){
        while(running){
            if(hasNewTime()){
                time=fetchTime();
                System.out.println(time.getHours()+":"+time.getMinutes()+":"+time.getSeconds());
            }
        }
    }

    public void halt(){
        running=false;
    }

    public Time getTime(){
        return time;
    }

    public Time fetchTime(){
        int h=LocalTime.now().getHour();
        int m=LocalTime.now().getMinute();
        int s=LocalTime.now().getSecond();
        return new Time(Integer.valueOf(((h<10)? "0"+h:""+h)), Integer.valueOf(((m<10)? "0"+m:""+m)), Integer.valueOf(((s<10)? "0"+s:""+s)));
    }

    public boolean hasNewTime(){
        Time newTime=fetchTime();
        if(time.equals(newTime)){
            return false;
        }
        return true;
    }
}