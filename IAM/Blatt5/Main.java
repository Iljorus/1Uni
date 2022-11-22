package Blatt5;

import myUtils.Lambda;
import myUtils.Logger;

public class Main{
    public static void main(String[] args) {
        Lambda func = (n) -> {return n*n;};
        func.run(2);
        Logger log=new Logger();
        log.toConsole("Console log");
        log.toFile("File Log");
        log.toFile("second");
    }
}