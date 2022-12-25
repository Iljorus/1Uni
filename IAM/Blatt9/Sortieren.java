package Blatt9;

public class Sortieren {
    
    public Sortieren(){
    }

    public static int[] sort(int[] x){
        int[] result=x;
        int changes=-1;
        while(changes!=0){
            changes=0;
            for(int i=1;i<result.length;i++){
                if(result[i]<result[i-1]){
                    changes++;
                    int cache=result[i-1];
                    result[i-1]=result[i];
                    result[i]=cache;
                }
            }
        }
        return result;
    }
}
