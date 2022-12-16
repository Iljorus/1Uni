package Blatt8;

public class Logarithmus {

    public Logarithmus(){
    }

    public static double lnRekurs(double x, double z){
        double res=(2*x)/(1+Math.sqrt(1+z*x));
        if(!(x>res)){
            return res;
        }

        return lnRekurs((2*x)/(1+Math.sqrt(1+z*x)), z/2);
    }

    public static double lnApprox(double x){
        double[] p={2, 0.6704, 0.35370773, 0.48674609};
        return ((x-1)/(x+1))*horner(Math.pow((x-1)/(x+1), 2), p);
    }

    private static double horner(double x, double[] koeffizienten){
        double result=koeffizienten[3];
        
        for(int k=1;k<=3;k++){
            result=(result*x)+koeffizienten[(3)-k];
        }
        return result;
    }
}
