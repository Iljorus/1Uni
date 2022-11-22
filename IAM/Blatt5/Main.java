package Blatt5;

import myUtils.Lambda;
import myUtils.Logger;

public class Main{
    public static void main(String[] args) {
        Lambda func = (n) -> {return n*n;};
        func.run(2);

        reference ref=new reference();
        test t= ref::print;
        t.run();
        Logger log=new Logger();
        log.toConsole(null);
    }
}