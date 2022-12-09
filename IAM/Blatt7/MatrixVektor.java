package Blatt7;

import java.util.Scanner;

import myUtils.userInput.*;
import myUtils.logger.*;

public class MatrixVektor {
    private double[][] matrix;
    private double[] vektor;
    private double[] result;
    private UserInput userInput;
    
    public MatrixVektor(int m, int n, Logger log){
        userInput=new UserInput(new Scanner(System.in), log);
        matrix=matrixEinlesen(m, n);
        matrixAusgeben(matrix);
        vektor=vektorEinlesen(n);
        vektorAusgeben(vektor, "Eingegebener");
        result=matrixVektorProdukt(matrix, vektor);
        vektorAusgeben(result, "Resultierender");
    }

    //m Zeilen, n Spalten
    public double[][] matrixEinlesen(int m, int n){
        double[][] output=new double[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                output[i][j]=(Double)userInput.print("Komponent a-"+(i+1)+" "+(j+1)+" der Matrix eingeben").get(InputType.Double);
            }
        }
        
        return output;
    }

    //n Zeilen
    public double[] vektorEinlesen(int n){
        double[] output=new double[n];

        for(int i=0;i<n;i++){
            output[i]=(Double)userInput.print("Komponent x-"+(i+1)+" des Vektors eingeben").get(InputType.Double);
        }

        return output;
    }

    public void vektorAusgeben(double[] vektor, String name){
        String output=name+" Vektor:\n( ";
        for(double dbl:vektor)output+=dbl+" ";
        System.out.println(output+")\n");
    }

    //i Zeilen, j Spalten
    public double[] matrixVektorProdukt(double[][] matrix, double[] vektor){
        double[] output=new double[matrix.length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                output[i]+=matrix[i][j]*vektor[j];
            }
        }

        return output;
    }

    public void matrixAusgeben(double[][] matrix){
        System.out.println("Matrix:\n");
        String[] output=new String[matrix.length];

        for(int i=0;i<matrix.length;i++){
            output[i]="( ";
            for(double dbl:matrix[i]){
                output[i]+=dbl+" ";
            }
            output[i]+=")";
        }

        for(String str:output)System.out.println(str);
        System.out.print("\n");
    }
}
