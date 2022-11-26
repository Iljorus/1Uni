package Blatt5;

import a5.Object;
import java.util.function.Consumer;;

public class Main<T> {
    public static void main(String[] args){
        new Main<String>().acc("run");
    }
    public void acc(T input){
        Consumer<T> c=(t) -> {
        Instance i=new Object()::body;
        i.run();
        };
        c.accept(input);
    }
}