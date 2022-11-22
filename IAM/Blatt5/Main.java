package Blatt5;

public class Main implements test, tust{
    public static void main(String[] args) {
        test first = (n) -> { return n+"!"; };
        tust second = (n, m) -> {return n+m;};
        System.out.println(first.run("Hi"));
        System.out.println(second.run(2, 3));

        Vector<String> strVec=new Vector<String>();
        strVec.set("strVec");
        strVec.print();
        Vector<Integer> intVec=new Vector<Integer>();
        intVec.set(12);
        intVec.print();
    }
    public String run(String s) {
        return null;
    }
    public int run(int i, int j){
        return 0;
    }
}