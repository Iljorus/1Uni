package Blatt5;

import myUtils.Lambda;

public class Main{
    public static void main(String[] args) {
        Lambda func = (n) -> {return n*n;};
        func.run(2);

     
        reference ref=new reference();
        test t= ref::print;
        t.run();
        System.out.println();
    }
}