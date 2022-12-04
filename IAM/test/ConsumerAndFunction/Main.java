package test.ConsumerAndFunction;

import java.util.function.Consumer;     //Lambda expression with 1 input and no return  (Functional Interface)
import java.util.function.Function;     //Lambda expression with 1 input and 1 return   (Functional Interface)

public class Main<T> {
    public static void main(String[] args){
        new Main<String>().acc("tst");
        System.out.println(new Main<Integer>().ac(2));
    }
    public void acc(T t){
        Consumer<T> c=(val) ->         //Headder, creates consumer function with name "c" and input "val" as type "T"
        System.out.println("HI");    //Body
        c.accept(t);                    //"accept" (interface method) applies param t (from method acc) to the body of "c"
    }
    public T ac(T t){
        Function<T, T> a= (te) ->       //Headder, creates function name "a", with input "te" type "T" and returns type "T"
        {
            return te;                  //Body
        };
        return a.apply(t);              //"apply" (interface method), applies param t (from method ac) to the body of "a" and gets the result
    }
}
