import java.lang.Math;

/**
 * This class enxtends function to define the abstract evaluate method of function used in the findRoot method of Function
 */
public class CosFunc extends Function{
    /**
     * This function evaluates cos(x).
     * @param x - double passed into the cosine function.
     */
    public double evaluate(double x){
        double xcos = Math.cos(x);
        return xcos;
    }
}
