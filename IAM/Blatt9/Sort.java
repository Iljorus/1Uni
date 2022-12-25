package Blatt9;

public class Sort {
    
    public Sort(){
    }

    public static int[] bubble(int[] x){
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
