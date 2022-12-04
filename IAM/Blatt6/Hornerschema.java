package Blatt6;

import java.util.Scanner;
import java.util.Locale;

public class Hornerschema {
    private int grad=0;
    private double[] koeffizienten;
    public Hornerschema(){
        run();
    }
    public void run(){
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);
        write("Grad des Polynoms:");
        String input=sc.nextLine();
        while(!input.matches("[0-9]+")){
            write("Falsche Eingabe, ganze Zahl erwartet.");
            input=sc.nextLine();
        }
        this.grad=Integer.valueOf(input);
        this.koeffizienten=new double[this.grad+1];
        for(int i=this.koeffizienten.length-1;i>=0;i--){
            write("Eingabe "+(this.koeffizienten.length-i)+"-ten Koeffizienten:");
            input=sc.nextLine();
            while(!input.matches("(-?)([0-9]+)(\\.[0-9]+)?")){
                write("Falsche Eingabe, reelle Zahl erwartet.");
                input=sc.nextLine();
            }
            koeffizienten[i]=Double.valueOf(input);
        }
        printP();
        write("\nWert fuer die Horner-Shema Evaulaion.\nZum beenden \"exit\" eingeben");
        while(true){
            input=sc.nextLine();
            if(input.equalsIgnoreCase("exit"))break;
            else if(input.matches("(-?)([0-9]+)(\\.[0-9]+)?")){
                double[] result=calcHorner(Double.valueOf(input));
                write("f("+input+") = "+result[0]+"\tf'("+input+") = "+result[1]);
            }
            else write("Invalide Eingabe. Bitte erneut versuchen");
        }
        sc.close();
    }
    public double[] calcHorner(double x){
        double y=koeffizienten[0];
        double z=koeffizienten[0];
        for(int k=1;k<=this.grad;k++){
            y=(y*x)+koeffizienten[(this.koeffizienten.length-1)-k];
            if(k<=this.grad-1)z=z*x+y;
        }
        double[] result=new double[2];
        result[0]=y;
        result[1]=z;
        return result;
    }
    public void printP(){
        String result="Eingegebenes Polynom: P(x) = ";
        for(int i=this.grad;i>1;i--){
            result+=this.koeffizienten[i]+"x^("+i+") + ";
        }
        write(result+this.koeffizienten[1]+"x + "+this.koeffizienten[0]);
    }
    public void write(String x){
        System.out.println(x);
    }
}