package Blatt7;

import myUtils.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        //TODO Gaus-algo
        Scanner sc=new Scanner(System.in);
        UserInput u=new UserInput(sc);
        //System.out.println(u.print("Bitte Wort eingeben").get("String"));
        String[] options={"Double", "String"};
        Object[] a=u.getNext(options);
        System.out.println(a[0]+"\t"+a[1]);
        sc.close();
    }
    
}
