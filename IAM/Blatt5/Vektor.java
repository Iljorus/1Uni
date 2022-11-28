package Blatt5;

import java.util.Scanner;
import java.util.Locale;

import myUtils.Logger;
import myUtils.Measurement;

public class Vektor {
    public Vektor(){
        vektor();
    }
    public void vektor(){
        Logger log=new Logger(String.valueOf(this.getClass()).split(" ")[1]);
        Measurement m=new Measurement(log);
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);
        log.logAndDefault("Bitte leange der Vektoren angeben");
        int n=sc.nextInt();
        double[] x=new double[n];
        double[] y=new double[n];
        log.toFile("User input: "+n);
        log.logAndDefault("Bitte eine Zahl fuer die Skalarmultiplikation eingeben");
        int l=sc.nextInt();
        log.toFile("User input: "+l);
        array ar=new array();
        log.logAndDefault("Zufaellige zahlen? Y/N");
        if(sc.next().equalsIgnoreCase("Y")){
            x=ar.fill(n);
            y=ar.fill(n);
        }
        else{
            log.logAndDefault("Bitte "+n+" Zahlen der form a, b, c, ... fuer Vektor x eigeben");
            sc.nextLine();
            String xIn=String.valueOf(sc.nextLine());
            log.toFile("User input: "+xIn);
            x=ar.toArray(xIn);
            log.logAndDefault("Bitte "+n+" Zahlen der form a, b, c, ... fuer Vektor y eigeben");
            String yIn=sc.nextLine();
            log.toFile("User input: "+yIn);
            y=ar.toArray(yIn);
        }
        m.start();
        System.out.println("");
        log.logAndDefault("x = "+ar.setResult(x).toString());
        log.logAndDefault("y = "+ar.setResult(y).toString());
        log.logAndDefault("x + y = "+ar.add(x, y).toString());
        log.logAndDefault("x - y = "+ar.sub(x, y).toString());
        log.logAndDefault("x * y = "+ar.mult(x, y).toString());
        if(ar.div(x, y).getResult()==null)log.logAndDefault("x / y = Fehler einer der Divisoren ist 0");
        else log.logAndDefault("x / y = "+ar.div(x, y).toString());
        log.logAndDefault("x * l = "+ar.skalarMult(x, l).toString());
        log.logAndDefault("y * l = "+ar.skalarMult(y, l).toString());
        log.logAndDefault("x @ y = "+String.valueOf(ar.skalarProd(x, y)));
        sc.close();
        m.end().result();
    }
}
