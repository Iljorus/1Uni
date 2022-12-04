package test.PatterAndMatcher;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args){
        Pattern p=Pattern.compile("(https?|ftp)://([^/\r\n]+)(/[^\r\n]*)?");        //Creates a pattern instance with given regex
        Matcher m=p.matcher("http://stackoverflow.com/");                           //Creates a matcher instance with given input and conditions from the pattern
        if(m.find()){                                                                      //Starts the matching process
            for(int i=1;i<=m.groupCount();i++){                                            //Iterates trough all the groups
                System.out.println("Group "+i+": "+m.group(i));                            //Writing the results
            }
        }
    }
}
