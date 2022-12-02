package Blatt6;

import java.util.Scanner;
import java.util.Locale;;

public class Hornerschema {
    private int grad=0;
    private double[] koeffizienten;
    public Hornerschema(){
        run();
    }
    public void run(){
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);
        this.grad=sc.nextInt();
        this.koeffizienten=new double[this.grad+1];
        for(int i=0;i<this.koeffizienten.length;i++){
            koeffizienten[i]=Double.valueOf(sc.next());
        }
        double x=sc.nextDouble();
        System.out.println(toString(calcHorner(x)));

        sc.close();
    }
    public double[] calcHorner(double x){
        double[] result=new double[2];
        double[] y=new double[this.grad];
        double[] z=new double[this.grad];
        y[0]=koeffizienten[koeffizienten.length-1];
        z[0]=koeffizienten[koeffizienten.length-1];
        System.out.println(y[0]+" "+z[0]);
        System.out.println();
        for(int k=1;k<this.grad;k++){
            y[k]=x*y[k-1]+koeffizienten[(this.grad-1)-k];
        }
        for(int k=1;k<this.grad-1;k++){
            z[k]=x*z[k-1]+y[k];
        }
        result[0]=y[this.grad-1];
        result[1]=z[this.grad-1];
        System.out.println(toString(y));
        System.out.println(toString(z));
        return result;
    }
    public String toString(double[] input){
        String result="";
        for(double d:input)result+=d+" ";
        return result;
    }
}
