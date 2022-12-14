package myUtils.time;

public class Stopwatch extends Thread{
    private volatile boolean running;
    private Time start;
    private Time end;
    public transient int test;

    public Stopwatch(Time t){
        running=true;
        end=t;
    }

    public void run(){
        while(running){

        }
    }

    public void halt(){
        running=false;
    }
}
