package Blatt9;

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
        for(int i=0;i<length;i++){
            blumentoepfe[i]=(Integer)userInput.print("Groessee des "+(i+1)+"-ten Blumentopf eingeben").get(InputType.Integer);
        }
        System.out.println(Styling.arrayToString(blumentoepfe));
        int[] result=Sortieren.sort(blumentoepfe);
        System.out.println(Styling.arrayToString(result));
    }
}
