package Blatt1;

import java.util.*;

public class EingabeAusgabe {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);
        System.out.println("Geben sie zwei ganze Zahlen ein: ");
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("Die Summe beider Zahlen lautet "+(a+b));
        System.out.println("Das Produkt der beiden Zahlen lautet. "+(a*b));
        sc.close();
    }
}
/*
Boolean: Wahrheitswerte
String: Zeichen (Buchstaben, Sätze, Zahlen als Text)

"long" hat einen hat einen größere Zahlenbereich als "int",
aber belegt auch mehr Platz im Arbeitsspeicher(32b vs 16b)
*/