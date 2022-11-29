package Blatt6;

import myUtils.Numbers;

public class Main {
    public static void main(String[] args){
        Numbers num=new Numbers();
        System.out.println(num.toDecimal("1001001", 2));
        System.out.println(num.toDecimal("A2E", 16));
        //System.out.println(num.toDecimal("19aB", 19872));   //Integer overflow
    }
}
