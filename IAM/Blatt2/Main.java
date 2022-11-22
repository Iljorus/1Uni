package Blatt2;

import java.util.*;

class Main{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);
        System.out.println("Bitte Hoehe und Durchmesser des Kegels nacheinander Eingeben\nHoehe:");
        double h=sc.nextDouble();
        System.out.println("Durchmesser:");
        double d=sc.nextDouble();
        Drehkegel kegel=new Drehkegel(h, d);
        double kegelOberflaeche=kegel.get("o");
        double kegelVolumen=kegel.get("v");
        System.out.println("Die Oberflaeche des Kegels betraegt: "+kegelOberflaeche+"\nDas Volumen betraegt: "+kegelVolumen);
        sc.close();
    }
}
/*
 * Durch das Kompilieren des Quellcodes wird der Java-Bytecode erstellt, welcher von der Maschine(Rechner) ausgeführt werden kann
 * 
 * Generell hat man sich beim Programmieren(mit wenigen ausnahmen) auf die sog. "Camelcase" schreibweise geeinigt.
 * D.h Wörter werden ohne Leerzeichen aneinandergehängt und der erste Buchstabe des neuen Wortes wird groß geschrieben.
 * Alternativ können wörter zur verbesserung der leserlichkeit auch durch Unterstriche getrentwerden.
 * Darüberhinnaus sollten Namen auch immer Sinnvoll sein.
 * Klassen solltem meistens mit einem Großbuchstaben beginnen, 
 * Variablen und Methoden mit einem kleinen.
 * Konstanten hingegen bestehen meistens ausschlieslich aus Großbuchstaben.
 * 
 * Klasse: MainKlasse
 * Methode: mainMethode
 * Variable: localeVariable
 * Konstante: GLOBALE_VARIABLE
 */