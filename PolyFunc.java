public class PolyFunc extends Function{

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
    
    //Debug Bools
    public static boolean debug = false;
    public static boolean constructDebug = false;

    //vars
    public static int[] reversed;
    public int degreeNum;
    public int[] myCoeffeints;

    public static void main(String[] args) {
        //test1
            int[] i = new int[]{0,0,0,1,2,0,3,4,5};
            PolyFunc pTest1 = new PolyFunc(i);
            System.out.println("\nHighest degree is " + pTest1.degree() + "\nPolyFunc in a string is " + pTest1.toString() + "\n");

        //test2
            int[] j = new int[]{2,-4,6,12};
            PolyFunc pTest2 = new PolyFunc(j);
            System.out.println("\nHighest degree is " + pTest2.degree() + "\nPolyFunc in a string is " + pTest2.toString() + "\n");

        //test3
           PolyFunc BothPolyFunc = pTest2.add(pTest1);
            System.out.println("\nThe added PolyFunc is " + BothPolyFunc.toString() + "\n\n");  
    }

    //Constructor
    public PolyFunc(int[] coeffeints){

        myCoeffeints = coeffeints;
        

        reversed = new int[coeffeints.length];

        for(int i = 0; i < coeffeints.length;i++){
            if (constructDebug)
                System.out.println(coeffeints[coeffeints.length-1-i]);
            reversed[i] = coeffeints[coeffeints.length-1-i];
            if (constructDebug)
                System.out.println(reversed[i]);
        }
        degreeNum = degree();
    }

    public PolyFunc add(PolyFunc a){

        int aDegree = a.myCoeffeints.length;
        int sDegree = myCoeffeints.length;
        int dif;
        int[] temp = new int[myCoeffeints.length];
        
        boolean check = true;
        dif = sDegree - aDegree;

        if (debug)
            System.out.println(degreeNum + " - " + aDegree + " dif before negative checker is " + dif);

        if (dif < 0){
            dif = aDegree - sDegree;
            check = false;
            temp = new int[a.myCoeffeints.length];
        }

        if (debug)
            System.out.println(" dif is " + dif);
        
        //FIRST LOOP
        for(int i = 0;i<dif;i++){
            if (check == true){
                temp[temp.length-1-i] = myCoeffeints[a.myCoeffeints.length-1-i];
            }
            else{
                temp[temp.length-1-i] = a.myCoeffeints[a.myCoeffeints.length-1-i];
            }
            if (debug)
                System.out.println("FIRST LOOP:\nTemp=" + i + " of temp is " + temp[i]);
        }

        int rest;
        if(check == false){
            if (debug)
                System.out.println("check is 0 which means that the second array is the larger one");
            rest = myCoeffeints.length+dif;
        }
        else{
            if (debug)
                System.out.println("check is 1 which means that the first array is the larger one");
            rest = a.myCoeffeints.length+dif;
        }

        if (debug){
            System.out.println("BREAK... rest is " + rest);
            System.out.println("start is " + myCoeffeints.length);
            System.out.println("second is " + a.myCoeffeints.length);
        }

        int j = 0;
        //SECOND LOOP
        for(int k = dif;k<rest;k++){
            if (check == true)
                temp[temp.length-1-k] = myCoeffeints[myCoeffeints.length-1-dif-j] + a.myCoeffeints[a.myCoeffeints.length-1-j];
            else
            temp[temp.length-1-k] = myCoeffeints[myCoeffeints.length-1-j] + a.myCoeffeints[a.myCoeffeints.length-1-dif-j];
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

        PolyFunc addedP = new PolyFunc(temp);

        return addedP;
    }

    public int degree(){
        int d;
        int counter = 0;

        //checks if the term of the PolyFunc is a 0
        while (reversed.length-1-counter == 0) {
            if (debug)
                System.out.println("Counter is " + counter);
            counter++;
        }

        d = reversed.length-1-counter ;

        return d;
    }

    public String toString(){
        String arrWithoutZeros = "";

        for(int k = 0; k < (reversed.length); k++){
            if (reversed[k] != 0){
                if(k > 0){
                    if (reversed[k] > 0)
                        arrWithoutZeros += "+";
                }
                arrWithoutZeros += Integer.toString(reversed[k]);
                if ((myCoeffeints.length-k-1) != 0)
                    arrWithoutZeros += ("x^" + (myCoeffeints.length-k-1));
            }
        }
        return arrWithoutZeros;
    }

}

