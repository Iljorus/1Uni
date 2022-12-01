package Blatt6;

import myUtils.*;

public class Main {
    public static void main(String[] args){
        Numbers num=new Numbers();
        System.out.println(num.convert("A2E", 16, 2));
        System.out.println(num.convert("101000101110", 2, 10));
        System.out.println(num.convert("14", 10, 16));

    }
}