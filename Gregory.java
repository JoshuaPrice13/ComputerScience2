import java.lang.Math;

public class Gregory {
    public static void main(String[] args){

        int input = 5;//Integer.parseInt(args[0]);
        double baseNumber = 0;

        //Finding Pi
        for(double i = 1; i < input+1; i++){
            double myNumerator = Math.pow((-1), i+1);
            double myDenominator = ((2 * i) - 1);

            baseNumber = baseNumber + myNumerator / myDenominator;
        }
        baseNumber = baseNumber*4;
        System.out.println("\nPi according to Gregory series: " + baseNumber);

        //Finding the difference
        double percent = (Math.PI - baseNumber)/Math.PI*100;
        System.out.println("This differs from Java's value by " + percent + " percent\n");

    }
}
