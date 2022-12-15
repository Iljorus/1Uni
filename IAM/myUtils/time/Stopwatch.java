package myUtils.time;

//import Bla

public class Stopwatch extends Thread{
    private volatile boolean running;
    private Time end;
    private Clock clock;

    public Stopwatch(Time offset){
        clock=new Clock();
        end=clock.getTime().add(offset);
        running=true;
        start();
    }

    public void run(){
        Time current=clock.getTime();
        while(running){
            if(current.equals(end))halt();
            current=clock.getTime();
        }
    }

    public void halt(){
        running=false;
        clock.halt();
    }
}
