package myUtils.userInput;

import java.util.Scanner;

import myUtils.logger.*;

public class UserInput {
    private final String INTEGER="(-?)[0-9]+";
    private final String DOUBLE="(-?)([0-9]+)(\\.[0-9]+)?";
    
    private Logger log;
    private Scanner sc;

    /**
     * This class handles user input trough the console
     * @param sc {@code Scanner} -> System.in
     */
    public UserInput(Scanner sc, Logger log){
        this.sc=sc;
        this.log=new Logger(this, log.getFile());
    }

    /**
     * Returns input from console as requested type
     * @param type {@code InfoType}
     * @return {@code Object} of requested type
     */
    public Object get(InputType type){
        while(true){
            String input=sc.nextLine();
            Object result=convertInput(input, type);
            if(result==null){
                print("Expected "+type+". Try again");
            }
            else {
                log.file("Requested "+type+", got: \""+String.valueOf(input)+"\"", InfoType.INFO);
                return result;
            }
        }
    }

    /**
     * Returns input matching one of the requested types, prioritizing the types closer to index 0
     * @param types {@code InfoType[]}
     * @return {@code Object} of one of requested types
     */
    public Object getNext(InputType[] types){
        while(true){
            String input=sc.nextLine();
            for(int i=0;i<types.length;i++){
                log.file("Requested input, type "+types[i], InfoType.INFO);
                log.file("Got: "+String.valueOf(input), InfoType.INFO);

                Object result=convertInput(input, types[i]);
                if(result==null){
                    print("Expected "+types+". Try again");
                }
                else{
                    log.file("Requested one of"+listTypes(types)+", got: \""+String.valueOf(input)+"\"", InfoType.INFO);
                    return result;
                }

                if(i==types.length){
                    System.out.println("maximal");  //TODO 
                }
            }
        }
    }

    private Object convertInput(String input, InputType type){
        switch(type){

            case String:{
                return input;
            }

            case Boolean:{
                if(input.equalsIgnoreCase("true") || input.equalsIgnoreCase("1")){
                    return Boolean.TRUE;
                }
                else if(input.equalsIgnoreCase("false") || input.equalsIgnoreCase("0")){
                    return Boolean.FALSE;
                }
            }

            case Integer:{
                if(input.matches(INTEGER)){
                    return Integer.valueOf(input);
                }
            }

            case PositiveInteger:{
                if(input.matches(INTEGER) && Integer.valueOf(input)>=0){
                    return Integer.valueOf(input);
                }
            }

            case NegativeInteger:{
                if(input.matches(INTEGER) && Integer.valueOf(input)<0){
                    return Integer.valueOf(input);
                }
            }

            case Double:{
                if(input.matches(DOUBLE)){
                    return Double.valueOf(input);
                }
            }

            case PositiveDouble:{
                if(input.matches(DOUBLE) && Double.valueOf(input)>=0){
                    return Double.valueOf(input);
                }
            }

            case NegativeDouble:{
                if(input.matches(DOUBLE) && Double.valueOf(input)<0){
                    return Double.valueOf(input);
                }
            }

            default:{
                return null;
            }
        }
    }

    /**
     * Prints {@code x} to console
     * @param x {@code String}
     * @return {@code this}
     */
    public UserInput print(String x){
        System.out.println(x);
        return this;
    }


    private String listTypes(InputType[] types){
        String output="";
        for(InputType type:types){
            output+=type;
        }

        return output;
    }
}
