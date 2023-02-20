/**
 * Represents a Polynomial object. Holds booleans used as switches used for debug purposes. Also holds a static and instance variables.
 */
public class Poly {

    //Debug Bools
    public static boolean debug = false;
    public static boolean constructDebug = false;

    //vars
    public static int[] reversed;
    public int degreeNum;
    public int[] mycoefficients;

    /**
     * Poly's main runs 3 test whcih constructs an instance of a poly and tests the other functions defined in Poly
     */
    public static void main(String[] args) {
        //test1
            int[] i = new int[]{3,4,5};
            Poly pTest1 = new Poly(i);
            System.out.println("\nHighest degree is " + pTest1.degree() + "\nPoly in a string is " + pTest1.toString() + "\n");
            System.out.println("ROOOOOOOOTSSSSS " + pTest1.evaluate(2));

        //test2
            int[] j = new int[]{2,-4,6,12};
            Poly pTest2 = new Poly(j);
            System.out.println("\nHighest degree is " + pTest2.degree() + "\nPoly in a string is " + pTest2.toString() + "\n");

        //test3
           Poly BothPoly = pTest2.add(pTest1);
            System.out.println("\nThe added Poly is " + BothPoly.toString() + "\n\n");
    }

    /**
     * This constructor of Poly takes the array of coefficients passed in and reverses the array into a new array called reversed
     * @param coefficients - array of ints that represent the coefficients of the polynomial
     */
    public Poly(int[] coefficients){

        mycoefficients = coefficients;
        reversed = new int[coefficients.length];

        for(int i = 0; i < coefficients.length;i++){
            if (constructDebug)
                System.out.println(coefficients[coefficients.length-1-i]);
            reversed[i] = coefficients[coefficients.length-1-i];
            if (constructDebug)
                System.out.println(reversed[i]);
        }
        degreeNum = degree();
    }

    /**
     * This is used on a Poly object to add another Poly to it. This is done by a series of for loops after checking which poly is larger.
     * @param a - Poly that is added to the existing Poly
     * @return - The new poly which is the sum of the two Poly objets.
     */
    public Poly add(Poly a){

        int aDegree = a.mycoefficients.length;
        int sDegree = mycoefficients.length;
        int dif;
        int[] temp = new int[mycoefficients.length];
        
        boolean check = true;
        dif = sDegree - aDegree;

        if (debug)
            System.out.println(degreeNum + " - " + aDegree + " dif before negative checker is " + dif);

        if (dif < 0){
            dif = aDegree - sDegree;
            check = false;
            temp = new int[a.mycoefficients.length];
        }

        if (debug)
            System.out.println(" dif is " + dif);
        
        //FIRST LOOP
        for(int i = 0;i<dif;i++){
            if (check == true){
                temp[temp.length-1-i] = mycoefficients[a.mycoefficients.length-1-i];
            }
            else{
                temp[temp.length-1-i] = a.mycoefficients[a.mycoefficients.length-1-i];
            }
            if (debug)
                System.out.println("FIRST LOOP:\nTemp=" + i + " of temp is " + temp[i]);
        }

        int rest;
        if(check == false){
            if (debug)
                System.out.println("check is 0 which means that the second array is the larger one");
            rest = mycoefficients.length+dif;
        }
        else{
            if (debug)
                System.out.println("check is 1 which means that the first array is the larger one");
            rest = a.mycoefficients.length+dif;
        }

        if (debug){
            System.out.println("BREAK... rest is " + rest);
            System.out.println("start is " + mycoefficients.length);
            System.out.println("second is " + a.mycoefficients.length);
        }

        int j = 0;
        //SECOND LOOP
        for(int k = dif;k<rest;k++){
            if (check == true)
                temp[temp.length-1-k] = mycoefficients[mycoefficients.length-1-dif-j] + a.mycoefficients[a.mycoefficients.length-1-j];
            else
            temp[temp.length-1-k] = mycoefficients[mycoefficients.length-1-j] + a.mycoefficients[a.mycoefficients.length-1-dif-j];
            if (debug){
                System.out.println("SECOND LOOP:\nTemp=" + k + " of temp is " + temp[k] + "\n");
            }
            j++;
        }
        
        if (debug){
            for(int t = 0;t<temp.length;t++){
                System.out.println("temp at " + t + " is " + temp[t]);
            }
        }

        Poly addedP = new Poly(temp);

        return addedP;
    }

    /**
     * This finds the largest degree of a polynomial.
     * @return - int value of the largest degree
     */
    public int degree(){
        int d;
        int counter = 0;

        //checks if the term of the Poly is a 0
        while (reversed.length-1-counter == 0) {
            if (debug)
                System.out.println("Counter is " + counter);
            counter++;
        }

        d = reversed.length-1-counter ;

        return d;
    }

    /**
     * This takes the Poly's reversed array of coefficients and adds the x variables and degree numbers to a String.
     * @return - String of the coefficients added with x's and degrees
     */
    public String toString(){
        String arrWithoutZeros = "";

        for(int k = 0; k < (reversed.length); k++){
            if (reversed[k] != 0){
                if(k > 0){
                    if (reversed[k] > 0)
                        arrWithoutZeros += "+";
                }
                arrWithoutZeros += Integer.toString(reversed[k]);
                if ((mycoefficients.length-k-1) != 0)
                    arrWithoutZeros += ("x^" + (mycoefficients.length-k-1));
            }
        }
        return arrWithoutZeros;
    }

    /**
     * This evaluates the polynomial with as specific x value that is passed in.
     * @param x - double that is used for each x in the polynomial
     * @return - double of the evaluated polynomial
     */
    public double evaluate(double x){
        double total = 0;
        for(int i = 0;i<reversed.length;i++){
            System.out.println("number in list is " + reversed[i]);
            if( degreeNum-i == 0 ){
                total += reversed[i];
                System.out.println("added " + reversed[i]);
            }
            else{
                total += Math.pow((reversed[i] * x), degreeNum-i);
                System.out.println("added " + Math.pow((reversed[i] * x), degreeNum-i));
            }
            
        }
        return total;
    }
}
