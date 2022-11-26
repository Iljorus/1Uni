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
        double[] XaddY=ar.add(x, y);
        double[] XsubY=ar.sub(x, y);
        double[] XmulY=ar.mult(x, y);
        double[] XdivY=ar.div(x, y);
        double[] XskalarMult=ar.skalarMult(x, l);
        double[] YskalarMult=ar.skalarMult(y, l);
        int XskalarProdY=ar.skalarProd(x, y);
        log.log("x = "+ar.toChar(x));
        log.log("y = "+ar.toChar(y));
        log.log("x + y = "+ar.toChar(XaddY));
        log.log("x - y = "+ar.toChar(XsubY));
        log.log("x * y = "+ar.toChar(XmulY));
        if(XdivY==null)log.log("x / y = Fehler einer der Divisoren ist 0");
        else log.log("x / y = "+ar.toChar(XdivY));
        log.log("x * l = "+ar.toChar(XskalarMult));
        log.log("y * l = "+ar.toChar(YskalarMult));
        log.log("x @ y = "+XskalarProdY);
        sc.close();
        m.end().result();
    }
}
