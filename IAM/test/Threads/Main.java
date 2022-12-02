package test.Threads;

public class Main {

private static volatile int MY_INT = 0;
public static void main(String[] args)
{
new ChangeListener().start();
new ChangeMaker().start();
}
}
