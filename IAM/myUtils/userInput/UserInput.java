package myUtils.userInput;

import java.util.Scanner;

public class UserInput {
    private final String INTEGER="(-?)[0-9]+";
    private final String DOUBLE="(-?)([0-9]+)(\\.[0-9]+)?";
    //private Logger log;
    private Scanner sc;
    public UserInput(Scanner sc){
        this.sc=sc;
        //this.log=new Logger(this, log.getFile());
    }
    public Object get(InputType type){
        while(true){
            String input=sc.nextLine();
            //log.file("Requested input, type "+type);
            //log.file("Got: "+String.valueOf(input));
            switch(type){
                case String:{
                    return input;
                }
                case Integer:{
                    if(input.matches(INTEGER))return Integer.valueOf(input);
                    else break;
                }
                case Boolean:{
                    if(input.equalsIgnoreCase("true") || input.equalsIgnoreCase("1"))return Boolean.TRUE;
                    else if(input.equalsIgnoreCase("false") || input.equalsIgnoreCase("0"))return Boolean.FALSE;
                    else break;
                }
                case Double:{
                    if(input.matches(DOUBLE))return Double.valueOf(input);
                    else break;
                }
                default:{
                    return "ERROR";
                }
            }
            print("Expected "+type+". Try again");
        }
    }
    public UserInput print(String x){
        //log.logAndDefault(x);
        System.out.println(x);
        return this;
    }
    public Object[] getNext(InputType[] types){
        Object[] result=new Object[2];
        while(true){
            String input=sc.nextLine();
            //log.file("Requested input, type "+type);
            //log.file("Got: "+String.valueOf(input));
            for(int i=0;i<types.length;i++){
                switch(types[i]){
                    case String:{
                        result[0]=input;
                        result[1]="String";
                        return result;
                    }
                    case Integer:{
                        if(input.matches(INTEGER)){
                            result[0]=Integer.valueOf(input);
                            result[1]="Integer";
                            return result;
                        }
                        else break;
                    }
                    case Boolean:{
                        if(input.equalsIgnoreCase("true") || input.equalsIgnoreCase("1")){
                            result[0]=Boolean.TRUE;
                            result[1]="Boolean";
                            return result;
                        }
                        else if(input.equalsIgnoreCase("false") || input.equalsIgnoreCase("0")){
                            result[0]=Boolean.FALSE;
                            result[1]="Boolean";
                            return result;
                        }
                        else break;
                    }
                    case Double:{
                        if(input.matches(DOUBLE)){
                            result[0]=Double.valueOf(input);
                            result[1]="Double";
                            return result;
                        }
                        else break;
                    }
                }
                if(i==types.length){
                    System.out.println("maximal");
                }
            }
        }
    }
}
