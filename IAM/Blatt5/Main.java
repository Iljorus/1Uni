package Blatt5;

public class Main implements test, tust{
    public static void main(String[] args) {
        test first = (n) -> { return n+"!"; };
        tust second = (n, m) -> {return n+m;};
        System.out.println(first.run("Hi"));
        System.out.println(second.run(2, 3));
        
    }
    public String run(String s) {
        return null;
    }
    public int run(int i, int j){
        return 0;
    }

}