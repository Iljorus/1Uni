package Blatt5;

public class Vector<T> {
    private T type;
    public Vector(){

    }
    public void set(T input){
        this.type=input;
    }
    public void print(){
        System.out.println(type);
    }
}
