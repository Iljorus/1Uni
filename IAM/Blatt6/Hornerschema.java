package Blatt6;

import myUtils.UserInput;

import java.util.Scanner;
import java.util.Locale;

public class Hornerschema {
    private int grad=0;
    private double[] koeffizienten;
    private final String REELLEZAHL="(-?)([0-9]+)(\\.[0-9]+)?";
    public Hornerschema(){
        run();
    }
    public void run(){

        //Creating "Scanner" instance and setting regional interpretation to "US"
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);
        UserInput in=new UserInput(sc);
        
        //Assigns the degree of the polonomial
        this.grad=(Integer)in.print("Grad des Polynoms:").getNext("Integer");

        //Assigns the koefficients of the polonomial
        this.koeffizienten=new double[this.grad+1];
        for(int i=this.koeffizienten.length-1;i>=0;i--){
            koeffizienten[i]=(Double)in.print("Eingabe "+(this.koeffizienten.length-i)+"-ten Koeffizienten:").getNext("Double");
        }
        //fill();
        printPoly();

        //
        String input="";
        write("\nWert fuer die Horner-Shema Evaulaion.\nZum beenden \"exit\" eingeben");
        while(true){
            input=(String)in.getNext("String");
            if(input.equalsIgnoreCase("exit"))break;
            else if(input.matches(REELLEZAHL)){
                double[] result=calcHorner(Double.valueOf(input));
                write("f("+input+") = "+result[0]+"\tf'("+input+") = "+result[1]);
            }
            else write("Invalide Eingabe, reelle Zahl erwartet.");
        }
        sc.close();
    }

    /**
     * Horner-scheme at {@code x}
     * @param x {@code double}
     * @return {@code double[0]}: f(x)      {@code double[1]}: f'(x)
     */
    public double[] calcHorner(double x){
        double y=koeffizienten[this.grad];
        double z=koeffizienten[this.grad];
        for(int k=1;k<=this.grad;k++){
            y=(y*x)+koeffizienten[(this.grad)-k];
            if(k<=this.grad-1)z=z*x+y;
        }
        double[] result=new double[2];
        result[0]=y;
        result[1]=z;
        return result;
    }

    /**
     * Prints polonomial
     */
    public void printPoly(){
        String result="\nEingegebenes Polynom: P(x) ="+((this.koeffizienten[this.grad]>0)?" ":" - ")+Math.abs(this.koeffizienten[this.grad])+" x^("+this.grad+")";
        for(int i=this.grad-1;i>1;i--){
            result+=((this.koeffizienten[i]>0)?" + ":" - ")+Math.abs(this.koeffizienten[i]) + " x^("+((i>1)?i:"")+")";
        }
        result+=((this.koeffizienten[0]>0)?" + ":" - ")+Math.abs(this.koeffizienten[0]);
        write(result);
    }

    /**
     * Prints {@code x} to console
     * @param x {@code String}
     */
    public void write(String x){
        System.out.println(x);
    }

    public void fill(){
        double RANGE=10;
        for(int i=0;i<=this.grad;i++){
            this.koeffizienten[i]=(RANGE/2)-RANGE*Math.random();
        }
    }
}