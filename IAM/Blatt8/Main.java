package Blatt8;

import myUtils.logger.*;

public class Main {
    public static void main(String[] args){
        Main m=new Main();
        m.run();
    }
    public void run() {
        Logger log=new Logger(this);
        Thread loggerThread=new Thread(log, "Logger");
        loggerThread.start();

        log.file("hi", InfoType.DEBUG);
        log.halt();
        log.file("hi", InfoType.DEBUG);
    }
}
