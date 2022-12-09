package Blatt5;

import java.util.Scanner;
import java.util.Locale;

import myUtils.Measurement;
import myUtils.logger.*;

public class Vektor {
    public Vektor(){
        vektor();
    }
    public void vektor(){
        Logger log=new Logger(this);
        Measurement m=new Measurement(log);
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);
        log.logAndDefault("Bitte leange der Vektoren angeben", InfoType.INFO);
        int n=sc.nextInt();
        double[] x=new double[n];
        double[] y=new double[n];
        log.file("User input: "+n, InfoType.INFO);
        log.logAndDefault("Bitte eine Zahl fuer die Skalarmultiplikation eingeben", InfoType.INFO);
        int l=sc.nextInt();
        log.file("User input: "+l, InfoType.INFO);
        array ar=new array();
        log.logAndDefault("Zufaellige zahlen? Y/N", InfoType.INFO);
        if(sc.next().equalsIgnoreCase("Y")){
            x=ar.fill(n);
            y=ar.fill(n);
        }
        else{
            log.logAndDefault("Bitte "+n+" Zahlen der form a, b, c, ... fuer Vektor x eigeben", InfoType.INFO);
            sc.nextLine();
            String xIn=String.valueOf(sc.nextLine());
            log.file("User input: "+xIn, InfoType.INFO);
            x=ar.toArray(xIn);
            log.logAndDefault("Bitte "+n+" Zahlen der form a, b, c, ... fuer Vektor y eigeben", InfoType.INFO);
            String yIn=sc.nextLine();
            log.file("User input: "+yIn, InfoType.INFO);
            y=ar.toArray(yIn);
        }
        m.start();
        System.out.println("");
        log.logAndDefault("x = "+ar.setResult(x).toString(), InfoType.INFO);
        log.logAndDefault("y = "+ar.setResult(y).toString(), InfoType.INFO);
        log.logAndDefault("x + y = "+ar.add(x, y).toString(), InfoType.INFO);
        log.logAndDefault("x - y = "+ar.sub(x, y).toString(), InfoType.INFO);
        log.logAndDefault("x * y = "+ar.mult(x, y).toString(), InfoType.INFO);
        if(ar.div(x, y).getResult()==null)log.logAndDefault("x / y = Fehler einer der Divisoren ist 0", InfoType.ERROR);
        else log.logAndDefault("x / y = "+ar.div(x, y).toString(), InfoType.INFO);
        log.logAndDefault("x * l = "+ar.skalarMult(x, l).toString(), InfoType.INFO);
        log.logAndDefault("y * l = "+ar.skalarMult(y, l).toString(), InfoType.INFO);
        log.logAndDefault("x @ y = "+String.valueOf(ar.skalarProd(x, y)), InfoType.INFO);
        sc.close();
        m.end().result();
    }
}
