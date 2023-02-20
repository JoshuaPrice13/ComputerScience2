public class Factorial {
    public static long calculate(long n){
        if (n == 0 || n == 1){
            return 1l;
        }
        if (n<0 || n>20){
            return 0;
        }
        if (n>1 || n<=20){
            return n * calculate(n-1);
        }
        return n;
    }
    public static void main(String []args){
        if(calculate(-1) == 0){
            System.out.println("Error! Factorial.calculate(-1) is out of range");
        }
        if (calculate(0) == 1){
            System.out.println("Factorial.calculate(0) returned 1 Test passed!");
        }
        else{System.out.println(" Test failed.");}

        if(calculate(5) == 120){
            System.out.println("Factorial.calculate(5) returned 120. Test passed!");
        }
        if(calculate(21) == 0){
            System.out.println("Error! Factoral.calculate(20) is out of range");
        }
    }
}
