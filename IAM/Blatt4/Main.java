package Blatt4;

import java.util.*;
import myUtils.Messurement;

public class Main {
   public static void main(String[] args){
      Messurement m=new Messurement();
      Locale.setDefault(Locale.US);
      Scanner sc=new Scanner(System.in);
      System.out.println("Bitte anzahl an Durchlaufen eingeben:");
      int experimentAnzahl=sc.nextInt();
      double torBehalten_M=0;
      double torWechseln_M=0;
      Ziegenproblem problem=new Ziegenproblem();
      m.start();
      for(int i=1;i<=experimentAnzahl;i++){
         torBehalten_M+=problem.torBehalten();
         torWechseln_M+=problem.torWechseln();
      }
      m.end();
      System.out.println("\nTrefferwarscheinlichkeit ohne Wechsel: "+torBehalten_M/experimentAnzahl);
      System.out.println("Trefferwarscheinlichkeit mit Wechsel: "+torWechseln_M/experimentAnzahl);
      System.out.println("\nVerarbeitungszeit: "+m.result());
      sc.close();
   }
}
/*
 * Bei println() wir ein "new line feed" hinzugefügt
 * 
 * for(Deklarations-Teil;Bedinguns-Teil;Iterations-Teil)
 * 
 * do: wir aufjedenfall einmal ausgeführt
 */
