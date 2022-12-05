package myUtils;

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
    public Object getNext(String type){
        while(true){
            String input=sc.nextLine();
            //log.file("Requested input, type "+type);
            //log.file("Got: "+String.valueOf(input));
            switch(type){
                case "String":{
                    return input;
                }
                case "Integer":{
                    if(input.matches(INTEGER))return Integer.valueOf(input);
                    else break;
                    
                }
                case "Boolean":{
                    if(input.equalsIgnoreCase("true") || input.equalsIgnoreCase("1"))return Boolean.TRUE;
                    else if(input.equalsIgnoreCase("false") || input.equalsIgnoreCase("0"))return Boolean.FALSE;
                    else break;
                }
                case "Double":{
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
    public void getThisOrThat(String dies, String das){
        //TODO multiplte return types shall be allowed


    }
}
