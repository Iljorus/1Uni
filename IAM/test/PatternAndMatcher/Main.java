package test.PatternAndMatcher;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args){

        //Creates a pattern instance with given regex
        Pattern p=Pattern.compile("(?:https?|ftp)://([^/\r\n]+)(/[^\r\n]*)?");

        //Creates a matcher instance with given input and conditions from the pattern
        Matcher m=p.matcher("https://stackoverflow.com/questions/3512471/what-is-a-non-capturing-group-in-regular-expressions");

        //Starts the matching process
        if(m.find()){

            //Iterates trough all the groups
            for(int i=1;i<=m.groupCount();i++){
                
                //Writing the results
                System.out.println("Group "+i+": "+m.group(i));
            }
        }
    }
}
