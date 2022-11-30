package myUtils;

public class cInt {
    public int rPart=0;
    public int iPart=0;
    public cInt(int r, int i){
        this.rPart=r;
        this.iPart=i;
    }
    public String getNum(){
        return +this.rPart+((this.iPart<0)?"":"+")+this.iPart+"i";
    }
    public cInt add(cInt x){
        this.rPart+=x.rPart;
        this.iPart+=x.iPart;
        return this;
    }
    public cInt sub(cInt x){
        this.rPart-=x.rPart;
        this.iPart-=x.iPart;
        return this;
    }
    public cInt mult(cInt x){
        int rCache=(this.rPart*x.rPart)-(this.iPart*x.iPart);
        int iCache=(this.rPart*x.iPart)+(x.rPart*this.iPart);
        this.rPart=rCache;
        this.iPart=iCache;
        return this;
    }
}
