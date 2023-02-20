

public class Factorial {
    public static double calculate(double n){
        if (n == 0 || n == 1){
            return 1.0;
        }
        if (n<0 || n>20){
            System.out.println("Error: Input out of bounds");
            return 0.0;
        }
        if (n>1 || n<=20){
            return n * calculate(n-1);
        }
        return n;
    }
    public static void main(String []args){
        if (calculate(0) == 1){
            System.out.println("Factoral.calculate(0) returned 1 Test passed!");
        }
        else{System.out.println(" Test failed.");}

        if(calculate(5) == 120){
            System.out.println("Factoral.calculate(5) returned 120. Test passed!");
        }
        else{System.out.println("5 Test failed.");}

        if(calculate(20) == 2432902008176640000d){
            System.out.println("Factoral.calculate(20) returned 2432902008176640000. Test passed!");
        }
        else{System.out.println("20 Test failed.");}

        System.out.println(calculate(16));
    }
   
}
