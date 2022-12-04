package test.ConsumerAndFunction;

//Lambda expression with 1 input and no return  (Functional Interface)
import java.util.function.Consumer;

//Lambda expression with 1 input and 1 return   (Functional Interface)
import java.util.function.Function;

public class Main<T> {
    public static void main(String[] args){
        new Main<String>().acc("tst");
        System.out.println(new Main<Integer>().ac(2));
    }
    public void acc(T t){

        //Creates consumer function with name "c" and input "val" as type "T"
        Consumer<T> c=(val) ->

        //Body
        {
            System.out.println("HI");
        };

        //"accept" (interface method) applies param t (from method acc) to the body of "c"
        c.accept(t);
    }
    public T ac(T t){

        //Creates function name "a", with input "te" type "T" and returns type "T"
        Function<T, T> a= (te) ->

        //Body
        {
            return te;
        };

        //"apply" (interface method), applies param t (from method ac) to the body of "a" and gets the result
        return a.apply(t);
    }
}
