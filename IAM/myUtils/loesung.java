package myUtils;

import java.util.Scanner;
import java.util.Locale;

public class loesung {
    public void aufg5(){
        Logger log=new Logger(String.valueOf(this.getClass()).split(" ")[1]);
        Measurement m=new Measurement(log);
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);
        log.log("Bitte leange der Vektors angeben");
        int n=sc.nextInt();
        double[] x=new double[n];
        double[] y=new double[n];
        log.log("User input: "+n);
        log.toFile("Bitte eine Zahl fuer die Skalarmultiplikation eingeben");
        int l=sc.nextInt();
        log.toFile("User input: "+l);
        m.start();
        array ar=new array();
        x=ar.fill(n);
        y=ar.fill(n);
        double[] XaddY=ar.add(x, y);
        double[] XsubY=ar.sub(x, y);
        double[] XmulY=ar.mult(x, y);
        double[] XdivY=ar.div(x, y);
        double[] XskalarMult=ar.skalarMult(x, l);
        double[] YskalarMult=ar.skalarMult(y, l);
        int XskalarProdY=ar.skalarProd(x, y);
        log.log("x + y = "+ar.toChar(XaddY));
        log.log("x - y = "+ar.toChar(XsubY));
        log.log("x * y = "+ar.toChar(XmulY));
        if(XdivY==null)log.log("Fehler einer der Divisoren ist 0");
        else log.log("x / y = "+ar.toChar(XdivY));
        log.log("x * l = "+ar.toChar(XskalarMult));
        log.log("y * l = "+ar.toChar(YskalarMult));
        log.log("x @ y = "+XskalarProdY);
        sc.close();
        m.end().result();
    }
}
