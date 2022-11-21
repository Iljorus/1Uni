import java.util.*;

public class absbetr {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);
        System.out.println("Geben sie eine belibige Zahl ein: ");
        double input=sc.nextDouble();
      /*if(input<0){
            input *= (-1);
            System.out.println("Der Betrag der Eingabe lautet: "+input);
        }else {
            System.out.println("Der Betrag der Eingabe lautet: "+input);
        } */
        System.out.println("Der Betrag der Eingabe lautet: "+Math.abs(input));
        sc.close();
    }
}
