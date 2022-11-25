package test;

import myUtils.Lambda;
import myUtils.Logger;
import myUtils.Measurement;

public class Main{
    public static void main(String[] args) {
        Lambda func = (n) -> {return n*n;};
        func.run(2);

        Logger log=new Logger("Main.java", false);
        Measurement m =new Measurement(log);
        m.start();

        reference ref=new reference();
        test t= ref::print;
        t.run();

        m.end().result();
        
        more mo=new more();
        System.out.println(mo.second().first().str.toString());
    }
}