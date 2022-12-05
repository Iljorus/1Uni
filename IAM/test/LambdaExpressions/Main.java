package test.LambdaExpressions;

public class Main {
    public static void main(String[] args){
        
        //Creates a new instance of the ReferencedClass
        ReferencedClass reference=new ReferencedClass();

        //The body of the lambda expression is assigned the body of the method "bodyOfAnotherClass" from the "ReferencedClass" 
        Interface lambdaExpression = reference::bodyOfAnotherClass;   
          
        //Executes the lambda expression
        lambdaExpression.run();
    }
}