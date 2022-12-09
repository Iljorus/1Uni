package Blatt7;

import myUtils.userInput.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        UserInput userInput=new UserInput(new Scanner(System.in));
        int m=(int)userInput.print("Dimension m der Matrix eingeben").get(InputType.Integer);
        int n=(int)userInput.print("Dimension n der Matrix eingeben").get(InputType.Integer);
        new MatrixVektor(m, n);
    }
    
}
