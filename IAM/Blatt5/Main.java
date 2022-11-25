package Blatt5;

import myUtils.*;

import myUtils.keineAhnung;

public class Main {
    Logger log=new Logger("Blatt4.Main.java");
    public static void main(String[] args){
        keineAhnung ka=new keineAhnung();
        keinProblem keineLoesung=ka::keinPlan;
        keineLoesung.run();
    }
}
