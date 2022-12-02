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
        System.out.println("Geben sie den Grad des Polynoms an");
        this.grad=sc.nextInt();
        this.koeffizienten=new double[this.grad+1];
        for(int i=this.koeffizienten.length-1;i>=0;i--){
            System.out.println("Geben sie den "+(this.koeffizienten.length-i)+"-ten Koeffizienten an");
            koeffizienten[i]=Double.valueOf(sc.next());
        }
        sc.nextLine();

        printP();
        System.out.println("\nSie koennen nun wiederholt werte in das Horner-Shema eingeben.\nZum beenden \"exit\" eingeben");
        while(true){
            String input=sc.nextLine();
            if(input.equalsIgnoreCase("exit"))break;
            else if(input.matches("-?[0-9]*")){
                double[] result=calcHorner(Double.valueOf(input));
                System.out.println("f(x)="+result[0]+"\tf'(x)="+result[1]);
            }
            else System.out.println("Invalide Eingabe. Bitte erneut versuchen");
        }
        sc.close();
    }
    public double[] calcHorner(double x){
        double[] result=new double[2];
        double y=koeffizienten[0];
        double z=koeffizienten[0];
        for(int k=1;k<=this.grad;k++){
            y=(y*x)+koeffizienten[(this.koeffizienten.length-1)-k];
            if(k<=this.grad-1)z=z*x+y;
        }
        result[0]=y;
        result[1]=z;
        return result;
    }
    public String toString(double[] input){
        String result="";
        for(double d:input)result+=d+" ";
        return result;
    }
    public void printP(){
        String result="Eingegebenes Polynom: ";
        for(int i=this.grad;i>0;i--){
            result+=this.koeffizienten[i]+"x^("+i+") + ";
        }
        System.out.println(result+this.koeffizienten[0]+"x^(0)");
    }
}