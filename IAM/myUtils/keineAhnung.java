package myUtils;

import java.util.Scanner;
import java.util.Locale;
import Blatt5.array;

public class keineAhnung {
    public void keinPlan(){
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double[] x=new double[n];
        double[] y=new double[n];
        int l=sc.nextInt();
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
        System.out.println("x + y = "+ar.toChar(XaddY));
        System.out.println("x - y = "+ar.toChar(XsubY));
        System.out.println("x * y = "+ar.toChar(XmulY));
        if(XdivY==null)System.out.println("Fehler einer der Divisoren ist 0");
        else System.out.println("x / y = "+ar.toChar(XdivY));
        System.out.println("x * l = "+ar.toChar(XskalarMult));
        System.out.println("y * l = "+ar.toChar(YskalarMult));
        System.out.println("x @ y = "+XskalarProdY);
        sc.close();
    }
}
