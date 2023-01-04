package Blatt9;

import java.util.Random;
import java.util.Scanner;

import myUtils.logger.Logger;
import myUtils.userInput.*;
import myUtils.Styling;

public class Main {
    public static void main(String[] args) {
        UserInput userInput=new UserInput(new Scanner(System.in), new Logger(new Main()));
        int length=(Integer)userInput.print("Anzahl der Blumentoepfe eingeben").get(InputType.Integer);
        while(length<=1){
            length=(Integer)userInput.print("Anzahl der Blumentoepfe muss eine ganze Zahl groesser 1 sein").get(InputType.Integer);
        }
        int[] blumentoepfe=new int[length];
        boolean fill=(Boolean)userInput.print("Fill?").get(InputType.Boolean);
        if(fill){
            blumentoepfe=fill(length, 100);
        }
        else{
            for(int i=0;i<length;i++){
                blumentoepfe[i]=(Integer)userInput.print("Groessee des "+(i+1)+"-ten Blumentopf eingeben").get(InputType.Integer);
            }
        }
        System.out.println("\nUrspruengliches Array\n"+Styling.arrayToString(blumentoepfe));
        int[] result=Sort.bubble(blumentoepfe);
        System.out.println("\nSortiertes Array\n"+Styling.arrayToString(result));
    }

    public static int[] fill(int length, int range){
        Random rand=new Random();
        range++;
        int[] output=new int[length];
        for(int i=0;i<length;i++){
            if(rand.nextInt(range*range)%2==0){
                output[i]=rand.nextInt(range);
            }
            else{
                output[i]=(-1)*rand.nextInt(range);
            }
        }
        return output;
    }
}
