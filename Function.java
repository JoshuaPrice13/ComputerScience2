
/**
 * This abstract class is used for other classes 
 * to extend and specify the function used to 
 * evaluate the root of a function.
 */
public abstract class Function {

    public static boolean debug = true;

    /**
     * This abstract method initializes the method that defines the function used to find a root
     * @param x - double passed into the function defined in inherited classes
     */
    public abstract double evaluate(double x);

    /**
     * The main of Function runs tests using the inherited classes of Function and prints out their roots.
     */
    public static void main(String []args){
        //test the SinFunc
        SinFunc s = new SinFunc();
        System.out.println(s.findRoot(3,4, 0.000000001));
        //test the CosFunc
        CosFunc c = new CosFunc();
        System.out.println(c.findRoot(1,3, 0.000000001));
        //test the PolyFunc
        int[] l = new int[]{3,0,1};
        PolyFunc p = new PolyFunc(l);
        System.out.println(p.findRoot(0, 5, 0.000000001));
    }

    /**
     * This function calls the abstract function evaluate until a root is found for the specific function defined in evaluate
     * @param a - minimum bound for the range of roots
     * @param b - maximum bound for the range of roots
     * @param epsilon - the amount of error allowed
     * @return - double that is the root of the evalute function
     */
    public double findRoot (double a, double b, double epsilon)
    {
        double x;

        x = (a+b)/2;

        if (Math.abs(a-x) < epsilon){
            if (debug)
                System.out.println("ROOT FOUND!");
            return x;
        }
        else if ((evaluate(a) > 0 && evaluate(x) > 0) || (evaluate(a) < 0 && evaluate(x) < 0)){
            if (debug)
                System.out.println("Root is LOWER than " + x);
            return findRoot(x, b, epsilon);
        }
        else {
            if (debug)
                System.out.println("Root is HIGHER than " + x);
            return findRoot(a, x, epsilon);
        }
    }
    
}

