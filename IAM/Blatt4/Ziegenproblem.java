package Blatt4;

public class Ziegenproblem{
    private int versuche=10000;
    private int treffer=0;
    private int tor_auto, tor_wahl, tor_offen, tor_alternative;
    public Ziegenproblem(){
    }
    public double torBehalten(){
        treffer=0;
        tor_auto=0;
        tor_wahl=0;
        for(int i=0;i<versuche;i++){
            tor_auto=(int) (1+3*Math.random());
            tor_wahl=(int) (1+3*Math.random());
        if(tor_auto==tor_wahl)treffer++;
        }
        return (double)treffer/(double)versuche;
    }
    public double torWechseln(){
        treffer=0;
        for(int i=0;i<versuche;i++){
            tor_auto=(int) (1+3*Math.random());
            tor_wahl=(int) (1+3*Math.random());
            tor_offen=(int) (1+3*Math.random());
            while(tor_offen==tor_auto || tor_offen==tor_wahl)tor_offen=(int) (1+3*Math.random());
            tor_alternative=(int) (1+3*Math.random());
            while(tor_alternative==tor_offen || tor_alternative==tor_wahl)tor_alternative=(int) (1+3*Math.random());
            if(tor_alternative==tor_auto)treffer++;
        }
        return (double)treffer/(double)versuche;
    }
    public double torWechselnSof(){
        treffer=0;
        tor_auto=0;
        tor_wahl=0;
        tor_offen=0;
        tor_alternative=0;
        for(int i=0;i<versuche;i++){
            tor_auto=(int) (1+3*Math.random());
            tor_wahl=(int) (1+3*Math.random());
            while(tor_offen==tor_auto || tor_offen==tor_wahl){
                System.out.println(tor_auto+"\t"+tor_wahl+"\t"+tor_offen);
                tor_offen=(int) (1+3*Math.random());
            }
            while(tor_alternative==tor_offen || tor_alternative==tor_wahl){
                tor_alternative=(int) (1+3*Math.random());
            }
            if(tor_alternative==tor_auto)treffer++;
        }
        return (double)treffer/(double)versuche;
    }
}