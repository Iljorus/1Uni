package Blatt8;

import myUtils.logger.*;

public class Main {
    public volatile boolean test=true;
    public static void main(String[] args){
        Main m=new Main();
        m.conc();
    }
    public void conc() {
        Logger log=new Logger(this);
        Thread loggerThread=new Thread(log, "Logger");
        loggerThread.start();
        log.setVar(this);

        log.file("hi", InfoType.DEBUG);
        test=false;
    }
}
