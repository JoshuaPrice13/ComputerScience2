import java.lang.Math;


public class FunctionTest {

    static public boolean debug = true;
    static double e = 0.00000001;

    public static void main(String []args){
        System.out.println("\nThe root of the function f(x)=sin(x) within the domain of 3<sin(x)<4 is:\n" + findRoot(3,4,e) + "\n");
    }

    public static double findRoot (double a, double b, double epsilon)
    {
        double x;

        x = (a+b)/2;

        if (Math.abs(a-x) < epsilon){
            if (debug)
            System.out.println("ROOT FOUND!");
            return x;
        }
        else if ((Math.sin(a) > 0 && Math.sin(x) > 0) || (Math.sin(a) < 0 && Math.sin(x) < 0)){
            if (debug)
            System.out.println("Root is LOWER than " + x);
            return findRoot(x, b, e);
        }
        else {
            if (debug)
            System.out.println("Root is HIGHER than " + x);
            return findRoot(a, x, e);
        }
    }
}
