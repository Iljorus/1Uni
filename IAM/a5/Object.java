package a5;

import java.util.Scanner;

import myUtils.Logger;
import myUtils.Measurement;

import java.util.Locale;

public class Object {
    public void body(){
        
        Logger log=new Logger(String.valueOf(this.getClass()).split(" ")[1]);
        Measurement m=new Measurement(log);
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);
        log.log("Bitte leange der Vektoren angeben");
        int n=sc.nextInt();
        double[] x=new double[n];
        double[] y=new double[n];
        log.toFile("User input: "+n);
        log.log("Bitte eine Zahl fuer die Skalarmultiplikation eingeben");
        int l=sc.nextInt();
        log.toFile("User input: "+l);
        array ar=new array();
        log.log("Zufaellige zahlen? Y/N");
        if(sc.next().equalsIgnoreCase("Y")){
            x=ar.fill(n);
            y=ar.fill(n);
        }
        else{
            log.log("Bitte "+n+" Zahlen der form a, b, c, ... fuer Vektor x eigeben");
            sc.nextLine();
            String xIn=String.valueOf(sc.nextLine());
            log.toFile("User input: "+xIn);
            x=ar.toArray(xIn);
            log.log("Bitte "+n+" Zahlen der form a, b, c, ... fuer Vektor y eigeben");
            String yIn=sc.nextLine();
            log.toFile("User input: "+yIn);
            y=ar.toArray(yIn);
        }
        m.start();
        log.log("x = "+ar.setResult(x).toString());
        log.log("y = "+ar.setResult(y).toString());
        log.log("x + y = "+ar.add(x, y).toString());
        log.log("x - y = "+ar.sub(x, y).toString());
        log.log("x * y = "+ar.mult(x, y).toString());
        if(ar.div(x, y).getResult()==null)log.log("x / y = Fehler einer der Divisoren ist 0");
        else log.log("x / y = "+ar.div(x, y).toString());
        log.log("x * l = "+ar.skalarMult(x, l).toString());
        log.log("y * l = "+ar.skalarMult(x, l).toString());
        log.log("x @ y = "+String.valueOf(ar.skalarProd(x, y)));
        sc.close();
        m.end().result();
    }
}
