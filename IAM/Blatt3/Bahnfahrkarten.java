package Blatt3;

public class Bahnfahrkarten {
    private final double BASIS_PREIS=0.3;
    private int tage;
    private int personen;
    private double fahrStrecke;

    public Bahnfahrkarten(int t, int p, double fS){
        this.tage=t;
        this.personen=p;
        this.fahrStrecke=fS;
    }
    private double tageRabatt(){
        if(tage>=1 && tage<3)return 0.9;
        else if(tage>=3 && tage<7)return 0.75;
        else if(tage>7)return 0.6;
        else return 1.0;
    }
    public double gesamtPreis(){
        double streckenPreis=this.fahrStrecke*BASIS_PREIS*tageRabatt();
        double gesamtPreis=0.0;
        for(int i=0;i<personen;i++){
            if(i==0)gesamtPreis+=streckenPreis;
            else if(i==1)gesamtPreis+=(streckenPreis*0.7);
            else gesamtPreis+=(streckenPreis*0.5);
        }
        return gesamtPreis;
    }

}
