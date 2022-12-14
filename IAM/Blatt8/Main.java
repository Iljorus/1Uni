package Blatt8;

import myUtils.time.*;

public class Main {
    public static void main(String[] args){
        int offset=10;
        if(args.length!=0){
            offset=Integer.valueOf(args[0]);
        }
        Clock c=new Clock();
        c.start();
        Time current=c.fetchTime();
        Time end=c.fetchTime();
        end.add(0, 0, offset);

        while(true){
            if(current.equals(end)){
                break;
            }
            if(c.hasNewTime())current=c.getTime();
        }
        c.halt();
    }
}
