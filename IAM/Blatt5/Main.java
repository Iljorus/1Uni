package Blatt5;

import myUtils.Lambda;
import myUtils.Logger;
import myUtils.Measurement;

public class Main{
    public static void main(String[] args) {
        Lambda func = (n) -> {return n*n;};
        func.run(2);

        Measurement m =new Measurement();
        m.start();

        reference ref=new reference();
        test t= ref::print;
        t.run();

        m.end().result();

        more mo=new more();
        System.out.println(mo.second().first().str.toString());
        "test".toString().replace("", "").toCharArray();
    }
}