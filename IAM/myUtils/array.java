package myUtils;

public class array {
    private final int MAX=49;
    private final int MIN=1;
    public array(){
    }
    public double[] add(double[] a, double[] b){
        double[] result=new double[a.length];
        for(int i=0;i<a.length;i++){
            result[i]=a[i]+b[i];
        }
        return result;
    }
    public double[] sub(double[] a, double[] b){
        double[] result=new double[a.length];
        for(int i=0;i<a.length;i++){
            result[i]=a[i]-b[i];
        }
        return result;
    }
    public double[] mult(double[] a, double[] b){   
        double[] result=new double[a.length];
        for(int i=0;i<a.length;i++){
            result[i]=a[i]*b[i];
        }
        return result;
    }
    public double[] div(double[] a, double[] b){
        double[] result=new double[a.length];
        int j=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==0 || b[i]==0)j++;
            else result[i]=a[i]/b[i];
        }
        if(j!=0){
            result=null;
        }
        return result;
    }
    public double[] skalarMult(double[] a, int b){
        double[] result=new double[a.length];
        for(int i=0;i<a.length;i++){
            result[i]=a[i]*b;
        }
        return result;
    }
    public int skalarProd(double[] a, double[] b){
        int result=0;
        for(int i=0;i<a.length;i++){
            result+=a[i]*b[i];
        }
        return result;
    }
    public double[] fill(int i){
        double[] k=new double[i];
        for(int j=0;j<k.length;j++){
            k[j]=(int)(MIN+(MAX-MIN)*Math.random());
        }
        return k;
    }
    public String toChar(double[] k){
        String result="[";
        for(int i=0;i<k.length;i++){
            result+=String.valueOf(k[i])+" ";
        }
        return result+"]";
    }
}
