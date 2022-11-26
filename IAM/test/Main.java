package test;

import myUtils.Lambda;

public class Main{
    public static void main(String[] args) {
        Lambda<Integer> func = (n) -> {return n*n;};
        func.run(2);
        Lambda<String> a=new reference<String>()::body;
        a.run("test");
    }
}