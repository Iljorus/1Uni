package Blatt7;

import java.util.Scanner;

import myUtils.userInput.*;

public class MatrixVektor {
    private double[][] matrix;
    private UserInput userInput=new UserInput(new Scanner(System.in));
    public MatrixVektor(){

    }

    //m Zeilen, n Spalten
    public double[][] matrixEinlesen(int m, int n){
        double[][] output=new double[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;i++){
                output[i][j]=(Double)userInput.get(InputType.Double);
            }
        }




        return output;
    }
    public double[] vektorEinlesen(){
        double[] output=null;





        return output;
    }
    public void vektorAusgeben(double[] vektor){

    }
    public double[] matrixVektorProdukt(double[][] matrix, double[] vektor){
        double[] output=null;





        return output;
    }
}
