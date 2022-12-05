package Blatt7;

import myUtils.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        UserInput u=new UserInput(sc);
        System.out.println(u.print("Bitte Wort eingeben").getNext("String"));
        sc.close();
    }
    
}
