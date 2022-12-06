package myUtils.algebra;

public class GaussAlgorithm {
    public GaussAlgorithm(){
        double[][] a={{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        double[] b={1, 2, 3};
        double[] result=algorithm(a, b);
        String out="";
        for(double d:result)out+=d+" ";
        System.out.println(out);
    }
    public double[] algorithm(double[][] a, double[] b){
        double faktor=0;
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                faktor= -a[j][i]/a[i][i];
                a[j][i]=0;
                for(int k=i+1;k<a.length;k++){
                    a[j][k]+=faktor*a[i][k];
                }
                b[j]+=faktor*b[i];
            }
        }
        return b;
    }
}
