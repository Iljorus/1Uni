import java.security.InvalidParameterException;

public class Drehkegel {
    private double h, d, r, s, g, m, o, v;
    Drehkegel(double h, double d){
        this.h=h;
        this.d=d;
        this.r=setRadius(this.d);
        this.s=setMantellinie(this.r, this.h);
        this.g=setGrundkreis(this.r);
        this.m=setMantelflaeche(this.r, this.s);
        this.o=setKegeloberflaeche(this.m, this.g);
        this.v=setKegelvolumen(this.g, this.h);
    }
    private double setRadius(double d){
        return d/2;
    }
    private double setMantellinie(double r, double h){
        return Math.sqrt(r*r+h*h);
    }
    private double setGrundkreis(double r){
        return Math.PI*r*r;
    }
    private double setMantelflaeche(double r, double s){
        return Math.PI*r*s;
    }
    private double setKegeloberflaeche(double m, double g){
        return m+g;
    }
    private double setKegelvolumen(double g, double h){
        return (this.g*h)/3;
    }
    public double get(String var){
        switch(var){
        case "h": return this.h;
        case "d": return this.d;
        case "r": return this.r;
        case "s": return this.s;
        case "g": return this.g;
        case "m": return this.m;
        case "o": return this.o;
        case "v": return this.v;
        default: throw new InvalidParameterException();
        }
    }
}