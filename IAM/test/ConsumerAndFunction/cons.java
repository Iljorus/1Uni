package test.ConsumerAndFunction;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class cons<T> {
    public static void main(String[] args){
        new cons<String>().acc("tst");
        System.out.println(new cons<Integer>().ac(2));
    }
    public void acc(T t){
        Consumer<T> c=(val) -> System.out.println("HI");
        c.accept(t);
    }
    public T ac(T t){
        Function<T, T> a= (te) ->{
            return te;
        };
        return a.apply(t);
    }
}
