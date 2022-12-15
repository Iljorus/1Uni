package myUtils.time;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int h, int m, int s){
        hours=h;
        minutes=m;
        seconds=s;
    }

    public Time(Time t){
        hours=t.getHours();
        minutes=t.getMinutes();
        seconds=t.getSeconds();
    }

    public Time add(int h, int m, int s){
        seconds+=s;
        if(seconds>=60){
            seconds-=60;
            minutes++;
        }
        minutes+=m;
        if(minutes>=60){
            minutes-=60;
            hours++;
        }
        hours+=h;
        if(hours>=24){
            hours-=24;
        }
        return this;
    }

    public Time add(Time t){
        add(t.getHours(), t.getMinutes(), t.getSeconds());
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Time other = (Time) obj;
        if (hours != other.hours)
            return false;
        if (minutes != other.minutes)
            return false;
        if (seconds != other.seconds)
            return false;
        return true;
    }

    @Override
    public String toString(){
        return ((hours>10)?""+hours:"0"+hours)+":"+
        ((minutes>10)?""+minutes:"0"+minutes)+":"+
        ((seconds>10)?""+seconds:"0"+seconds);

    }

    public int getHours(){
        return hours;
    }

    public int getMinutes(){
        return minutes;
    }
    
    public int getSeconds(){
        return seconds;
    }
}
