package Blatt5;

import myUtils.Lambda;
import myUtils.Logger;
import myUtils.Messurement;

public class Main{
    public static void main(String[] args) {
        Lambda func = (n) -> {return n*n;};
        func.run(2);

        Messurement m =new Messurement();
        m.start();

        reference ref=new reference();
        test t= ref::print;
        t.run();

        Logger log=new Logger();
        log.toConsole("Bruh");
        m.end();
        log.toConsole(m.result());
        String[] test={"1", "2"};
        System.out.println(test.toString().split(""));
    }
}