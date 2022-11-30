package Blatt6;

import myUtils.*;

public class Main {
    public static void main(String[] args){
    cInt a=new cInt(1, 1);
    cInt b=new cInt(1, 2);
    System.out.println(a.add(b).getNum());
    System.out.println(a.mult(b).getNum());
    System.out.println(a.sub(b).getNum());
    System.out.println(a.sub(b).getNum());
    System.out.println(a.sub(b).getNum());
    }
}
