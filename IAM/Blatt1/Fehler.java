package Blatt1;     //Wegen mir

import java.util.*; //Scanner nicht importiert

public class Fehler {
    public static void main(String[] args){
        int a, b, c;    //Variable "c" nicht initialisiert
        Scanner sc=new Scanner(System.in);  //Scanner nicht geöffnet
        System.out.println("Geben Sie drei natuerliche Zahlen ein!");
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        int d=a+b-c;    //Semicolon vergessen
        System.out.println("a+b-c = "+d) ;//"=" muss noch in den String rein; "+" vor dem "d" vergessen
        sc.close(); //Scanner nicht geschlossen
    }
}
