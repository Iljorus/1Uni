package Blatt8;

import myUtils.time.*;

public class Main {
    public volatile Clock clock;
    public static void main(String[] args){
        Main m=new Main();
        m.clock=new Clock();
        new Stopwatch(new Time(0, 0, 2));
    }
}
