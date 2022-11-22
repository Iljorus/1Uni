package Blatt5;

import myUtils.Lambda;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        Lambda func = (n) -> {return n*n;};
        func.run(2);
        ArrayList<Integer> array=new ArrayList<>();
        array.forEach(s -> System.out.println(s));

        System.out.println();
    }
}