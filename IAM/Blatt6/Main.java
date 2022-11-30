package Blatt6;

import myUtils.*;

public class Main {
    public static void main(String[] args){
    cInt a=new cInt(1, 1);
    cInt b=new cInt(1, 2);
    System.out.println(a.add(b).val);
    System.out.println(a.mult(b).val);
    System.out.println(a.div(b).val);
    System.out.println(a.sub(b).val);
    }
}
