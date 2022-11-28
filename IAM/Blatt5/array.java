package Blatt5;

public class array {
    private final int MAX=49;
    private final int MIN=1;
    private double[] result;
    public array(){
    }
    public array add(double[] a, double[] b){
        this.result=new double[a.length];
        for(int i=0;i<a.length;i++)this.result[i]=a[i]+b[i];
        return this;
    }
    public array sub(double[] a, double[] b){
        this.result=new double[a.length];
        for(int i=0;i<a.length;i++)this.result[i]=a[i]-b[i];
        return this;
    }
    public array mult(double[] a, double[] b){   
        this.result=new double[a.length];
        for(int i=0;i<a.length;i++)this.result[i]=a[i]*b[i];
        return this;
    }
    public array div(double[] a, double[] b){
        this.result=new double[a.length];
        int j=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==0.0 || b[i]==0.0)j++;
            else this.result[i]=a[i]/b[i];
        }
        if(j!=0)this.result=null;
        return this;
    }
    public array skalarMult(double[] a, int b){
        this.result=new double[a.length];
        for(int i=0;i<a.length;i++)result[i]=a[i]*b;
        return this;
    }
    public int skalarProd(double[] a, double[] b){
        int result=0;
        for(int i=0;i<a.length;i++)result+=a[i]*b[i];
        return result;
    }
    public double[] fill(int i){
        double[] k=new double[i];
        for(int j=0;j<k.length;j++)k[j]=(int)(MIN+(MAX-MIN)*Math.random());
        return k;
    }
    public String toString(){
        String result="[";
        for(int i=0;i<this.result.length-1;i++)result+=String.valueOf(this.result[i])+" ";
        return result+String.valueOf(this.result[this.result.length-1])+"]";
    }
    public double[] toArray(String input){
        String[] numbers=input.split(", ");
        double[] output=new double[numbers.length];
        for(int i=0;i<numbers.length;i++)output[i]=Integer.valueOf(numbers[i]);
        return output;
    }
    public double[] getResult(){
        return this.result;
    }
    public array setResult(double[] x){
        this.result=x;
        return this;
    }
}
