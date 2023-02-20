import java.lang.Math;

/**
 * Extends Function class and defines its abstract method
 */
public class SinFunc extends Function {
    /**
     * Defines evaluate initialized in Functinon. This uses sin(x) as the function to evaluate.
     * @param x - double passes into sine function
     * @return - double of sine evaluated with xs
     */
    public double evaluate(double x) {
        double xsin = Math.sin(x);
        return xsin;
    }
    
}
