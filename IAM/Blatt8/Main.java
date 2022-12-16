package Blatt8;

import java.util.Scanner;

import myUtils.logger.Logger;
import myUtils.userInput.*;

public class Main {
    public static void main(String[] args){
        UserInput userInput=new UserInput(new Scanner(System.in), new Logger(new Main()));

        while(true){
            Double input=(Double)userInput.print("").get(InputType.Double);
            if(input<1){
                System.out.println("Invalid input, process terminating");
                break;
            }
            double ln=Math.log(input);
            double l_r=Logarithmus.lnRekurs(input-1, 1);
            double l_a=Logarithmus.lnApprox(input);

            double d_r=Math.abs(ln-l_r)/Math.abs(ln);
            double d_a=Math.abs(ln-l_a)/Math.abs(ln);

            System.out.println("x = "+input+"\tln(x)\t= "+ln);          //mit \t is cringe weil manchmal eins fehlt bzw eins zu viel
            System.out.println("\t\tl_r (x)\t= "+l_r+"\td_r = "+d_r);
            System.out.println("\t\tl_a (x)\t= "+l_a+"\td_a = "+d_a);
        }
    }
}
