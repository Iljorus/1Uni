package Blatt4;

import java.util.*;
import myUtils.Measurement;
import myUtils.Logger;

public class Main {
   public static void main(String[] args){
      Logger log=new Logger("Blatt4.Main.java", false);
      Measurement m=new Measurement(log);
      Locale.setDefault(Locale.US);
      Scanner sc=new Scanner(System.in);
      System.out.println("Bitte anzahl an Durchlaufen eingeben");
      int experimentAnzahl=sc.nextInt();
      double torBehalten_M=0;
      double torWechseln_M=0;
      Ziegenproblem problem=new Ziegenproblem();
      m.start();
      for(int i=1;i<=experimentAnzahl;i++){
         torBehalten_M+=problem.torBehalten();
         torWechseln_M+=problem.torWechseln();
      }
      m.end().result();
      System.out.println("Trefferwarscheinlichkeit ohne Wechsel: "+torBehalten_M/experimentAnzahl);
      System.out.println("Trefferwarscheinlichkeit mit Wechsel: "+torWechseln_M/experimentAnzahl);
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
