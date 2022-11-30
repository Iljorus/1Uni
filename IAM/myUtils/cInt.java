package myUtils;

public class cInt {
    public int rPart=0;
    public int iPart=0;
    public String val="0+0i";
    /**
     * Creates a new complex number
     * @param r Real part of the complex number as {@code int}
     * @param i Imaginary part of the complex number as {@code int}
     */
    public cInt(int r, int i){
        this.rPart=r;
        this.iPart=i;
        updateVal();
    }
    /**
     * @return Real and imaginary part as {@code String}
     */
    public String getNum(){     //Deprecated
        return this.rPart+((this.iPart<0)?"":"+")+this.iPart+"i";
    }
    public cInt setVal(int r, int i){
        this.rPart=r;
        this.iPart=i;
        updateVal();
        return this;
    }
    private void updateVal(){
        this.val=this.rPart+((this.iPart<0)?"":"+")+this.iPart+"i";
    }
    /**
     * Adds {@code x} from {@code this}
     * @param x Number 
     * @return cInt {@code this}
     */
    public cInt add(cInt x){
        this.rPart+=x.rPart;
        this.iPart+=x.iPart;
        updateVal();
        return this;
    }
    /**
     * Subtracts {@code x} from {@code this} 
     * @param x Number 
     * @return cInt {@code this}
     */
    public cInt sub(cInt x){
        this.rPart-=x.rPart;
        this.iPart-=x.iPart;
        updateVal();
        return this;
    }
    /**
     * Multiplies {@code this} with {@code x} 
     * @param x Number 
     * @return cInt {@code this}
     */
    public cInt mult(cInt x){
        int rCache=(this.rPart*x.rPart)-(this.iPart*x.iPart);
        int iCache=(this.rPart*x.iPart)+(x.rPart*this.iPart);
        this.rPart=rCache;
        this.iPart=iCache;
        updateVal();
        return this;
    }
    /**
     * Divides {@code this} with {@code x} 
     * @param x Number 
     * @return cInt {@code this}
     */
    public cInt div(cInt x){
        int rCache=((this.rPart*x.rPart)+(this.iPart*x.iPart))/((int)Math.pow(x.rPart, 2)+(int)Math.pow(x.iPart, 2));
        int iCache=((x.rPart*this.iPart)-(this.rPart*x.iPart))/((int)Math.pow(x.rPart, 2)+(int)Math.pow(x.iPart, 2));
        this.rPart=rCache;
        this.iPart=iCache;
        updateVal();
        return this;
    }
}
