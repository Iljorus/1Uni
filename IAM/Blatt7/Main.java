package Blatt7;

import myUtils.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        //TODO Gaus-algo
        Scanner sc=new Scanner(System.in);
        UserInput u=new UserInput(sc);
        System.out.println(u.print("Bitte Wort eingeben").getNext("String"));
        String[] input={"Double", "String", "Integer"};
        System.out.println(u.getThisOrThat(input).getClass());
        sc.close();
    }
    
}
