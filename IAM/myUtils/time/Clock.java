package myUtils.time;

import java.time.LocalTime;

public class Clock extends Thread{
    private volatile boolean running;
    private volatile Time time;

    public Clock(){
        time=fetchTime();
        running=true;
        start();
    }

    public void run(){
        while(running){
            if(hasNewTime()){
                time=fetchTime();
            }
        }
    }

    public void halt(){
        running=false;
    }

    public Time getTime(){
        return new Time(this.time);
    }

    private Time fetchTime(){
        int h=LocalTime.now().getHour();
        int m=LocalTime.now().getMinute();
        int s=LocalTime.now().getSecond();
        return new Time(h, m, s);
    }

    public boolean hasNewTime(){
        Time newTime=fetchTime();
        if(time.equals(newTime)){
            return false;
        }
        return true;
    }
}