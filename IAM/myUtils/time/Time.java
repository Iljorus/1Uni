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

    public void add(int h, int m, int s){
        seconds+=s;
        if(seconds>60){
            seconds-=60;
            minutes++;
        }
        minutes+=m;
        if(minutes>60){
            minutes-=60;
            hours++;
        }
        hours+=h;
        if(hours>24){
            hours-=24;
        }
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
