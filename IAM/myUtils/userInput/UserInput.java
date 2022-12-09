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
            log.file("Requested input as "+type+", Got: "+String.valueOf(input)+" as "+getInstance(input), InfoType.INFO);
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

    /**
     * Returns input matching one of the requested types, prioritizing the types closer to index 0
     * @param types {@code InfoType[]}
     * @return {@code Object} of one of requested types
     */
    public Object getNext(InputType[] types){
        while(true){
            String input=sc.nextLine();
            //log.file("Requested input, type "+type);
            //log.file("Got: "+String.valueOf(input));
            for(int i=0;i<types.length;i++){
                switch(types[i]){

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
                }

                if(i==types.length){
                    System.out.println("maximal");
                }
            }
        }
    }

    /**
     * Prints {@code x} to console
     * @param x {@code String}
     * @return {@code this}
     */
    public UserInput print(String x){
        //log.logAndDefault(x);
        System.out.println(x);
        return this;
    }
    public String getInstance(Object obj){
        return String.valueOf(obj.getClass()).split(" ")[1].split("\\.")[2];
    }
}
