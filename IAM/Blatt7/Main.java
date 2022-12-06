package Blatt7;

import myUtils.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        String[] input={"1", "2", "3", "4"};
        String[] a=input.clone();
        String[] b=input;
        String[] c=input;
        b[0]=null;
        System.out.println(String.join(" ", a));
        System.out.println(String.join(" ", b));
        System.out.println(String.join(" ", c));
    }
    
}
