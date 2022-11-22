package Blatt3;

import java.util.*;

class Main{
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);
        System.out.println("Wieviele reisende?");
        int personen=sc.nextInt();
        if(personen<1){
            System.out.println("ERROR: UNGUELTIGE REISENDEN ANZAHL");
            System.exit(0);
        }
        System.out.println("Wieviele Tage bis zum Fahrantritt?");
        int tage=sc.nextInt();
        if(tage<0){
            System.out.println("ERROR: UNGUELTIGE TAGES ANZAHL");
            System.exit(0);
        }
        System.out.println("Wieviele Kilometer?");
        double fahrStrecke=sc.nextDouble();
        if(fahrStrecke<=0.0){
            System.out.println("ERROR: UNGUELTIGE KILOMETER ANZAHL");
            System.exit(0);
        }
        Bahnfahrkarten karten=new Bahnfahrkarten(tage, personen, fahrStrecke);
        System.out.println("Der Preis fuer die Fahrkarten betraegt: "+karten.gesamtPreis());
        sc.close();
    }
}
/*
 * Deklarieren: Variable mit Typ und Name schon einmal "reservieren"
 * Initialisieren: Variable wird wert zugewiesen
 * 
 * PI als Konstante: "final double PI=3.1415"
 */