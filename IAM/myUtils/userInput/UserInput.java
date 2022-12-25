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
            switch(type){
                case String:{
                    log.file("Requested "+type+", got: \""+String.valueOf(input)+"\" as String", InfoType.INFO);
                    return input;
                }

                case Integer:{
                    if(input.matches(INTEGER)){
                        log.file("Requested "+type+", got: \""+String.valueOf(input)+"\" as Integer", InfoType.INFO);
                        return Integer.valueOf(input);
                    }
                }

                case PositiveInteger:{
                    if(input.matches(INTEGER) && Integer.valueOf(input)>=0){
                        log.file("Requested "+type+", got: \""+String.valueOf(input)+"\" as Integer", InfoType.INFO);
                        return Integer.valueOf(input);
                    }
                }

                case NegativeInteger:{
                    if(input.matches(INTEGER) && Integer.valueOf(input)<0){
                        log.file("Requested "+type+", got: \""+String.valueOf(input)+"\" as Integer", InfoType.INFO);
                        return Integer.valueOf(input);
                    }
                }

                case Boolean:{
                    if(input.equalsIgnoreCase("true") || input.equalsIgnoreCase("1")){
                        log.file("Requested "+type+", got: \""+String.valueOf(input)+"\" as Boolean", InfoType.INFO);
                        return Boolean.TRUE;
                    }
                    else if(input.equalsIgnoreCase("false") || input.equalsIgnoreCase("0")){
                        log.file("Requested "+type+", got: \""+String.valueOf(input)+"\" as Boolean", InfoType.INFO);
                        return Boolean.FALSE;
                    }
                }

                case Double:{
                    if(input.matches(DOUBLE)){
                        log.file("Requested "+type+", got: \""+String.valueOf(input)+"\" as Double", InfoType.INFO);
                        return Double.valueOf(input);
                    }
                }

                case PositiveDouble:{
                    if(input.matches(DOUBLE) && Double.valueOf(input)>=0){
                        log.file("Requested "+type+", got: \""+String.valueOf(input)+"\" as Double", InfoType.INFO);
                        return Double.valueOf(input);
                    }
                }

                case NegativeDouble:{
                    if(input.matches(DOUBLE) && Double.valueOf(input)<0){
                        log.file("Requested "+type+", got: \""+String.valueOf(input)+"\" as Double", InfoType.INFO);
                        return Double.valueOf(input);
                    }
                }

                default:{
                    log.file("Requested "+type+", got: \""+String.valueOf(input)+"\" as String", InfoType.INFO);
                    print("Expected "+type+". Try again");
                    break;
                }
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
            //log.file("Requested input, type "+type);
            //log.file("Got: "+String.valueOf(input));
            for(int i=0;i<types.length;i++){
                switch(types[i]){

                    case String:{
                        log.file("Requested "+types[i]+", got: \""+String.valueOf(input)+"\" as String", InfoType.INFO);
                        return input;
                    }
    
                    case Integer:{
                        if(input.matches(INTEGER)){
                            log.file("Requested "+types[i]+", got: \""+String.valueOf(input)+"\" as Integer", InfoType.INFO);
                            return Integer.valueOf(input);
                        }
                    }
    
                    case PositiveInteger:{
                        if(input.matches(INTEGER) && Integer.valueOf(input)>=0){
                            log.file("Requested "+types[i]+", got: \""+String.valueOf(input)+"\" as Integer", InfoType.INFO);
                            return Integer.valueOf(input);
                        }
                    }
    
                    case NegativeInteger:{
                        if(input.matches(INTEGER) && Integer.valueOf(input)<0){
                            log.file("Requested "+types[i]+", got: \""+String.valueOf(input)+"\" as Integer", InfoType.INFO);
                            return Integer.valueOf(input);
                        }
                    }
    
                    case Boolean:{
                        if(input.equalsIgnoreCase("true") || input.equalsIgnoreCase("1")){
                            log.file("Requested "+types[i]+", got: \""+String.valueOf(input)+"\" as Boolean", InfoType.INFO);
                            return Boolean.TRUE;
                        }
                        else if(input.equalsIgnoreCase("false") || input.equalsIgnoreCase("0")){
                            log.file("Requested "+types[i]+", got: \""+String.valueOf(input)+"\" as Boolean", InfoType.INFO);
                            return Boolean.FALSE;
                        }
                    }
    
                    case Double:{
                        if(input.matches(DOUBLE)){
                            log.file("Requested "+types[i]+", got: \""+String.valueOf(input)+"\" as Double", InfoType.INFO);
                            return Double.valueOf(input);
                        }
                    }
    
                    case PositiveDouble:{
                        if(input.matches(DOUBLE) && Double.valueOf(input)>=0){
                            log.file("Requested "+types[i]+", got: \""+String.valueOf(input)+"\" as Double", InfoType.INFO);
                            return Double.valueOf(input);
                        }
                    }
    
                    case NegativeDouble:{
                        if(input.matches(DOUBLE) && Double.valueOf(input)<0){
                            log.file("Requested "+types[i]+", got: \""+String.valueOf(input)+"\" as Double", InfoType.INFO);
                            return Double.valueOf(input);
                        }
                    }
    
                    default:{
                        log.file("Requested "+types[i]+", got: \""+String.valueOf(input)+"\" as String", InfoType.INFO);
                        print("Expected "+listTypes(types)+". Try again");
                        break;
                    }
                }

                if(i==types.length){
                    System.out.println("maximal");  //TODO 
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

    private String listTypes(InputType[] types){
        String output="";
        for(InputType type:types){
            output+=type;
        }

        return output;
    }
}
