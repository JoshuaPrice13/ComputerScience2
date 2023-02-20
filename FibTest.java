import java.util.ArrayList;


public class FibTest {

    public static void main(String []args) {
        double IterStartTime = System.currentTimeMillis();
        System.out.println("Fibonacci's number at 40 is " + fibIter(40));
        double IterStopTime = System.currentTimeMillis();
        System.out.println("The Test using the Iteration method took " + (IterStopTime-IterStartTime) + " milliseconds.");

        double RecurStartTime = System.currentTimeMillis();
        System.out.println("Fibonacci's number at 40 is " + fibRecur(40));
        double RecurStopTime = System.currentTimeMillis();
        System.out.println("The Test using the Recursion method took " + (RecurStopTime-RecurStartTime) + " milliseconds.");
        
    }

    public static int fibIter(int n){
        
        //Using ArrayList to add Fibonacci numbers
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(1);

        int indexCounter = 2;

        //loops the formula for Fibonacci's numbers n amount of times
        for(int i = 1; i<n;i++){
            list1.add(list1.get(indexCounter-2)+list1.get(indexCounter-1));
            indexCounter++;
        }
        return list1.get(indexCounter-1);
        
    }
 
    public static int fibRecur(int n){

        if (n == 0 || n == 1)
            return 1;
        else if (n>1){
            return (fibRecur(n-2)+fibRecur(n-1));
        }
        else {
            System.out.print("Error: Input is out of Bounds ");
            return 0;
        }
    }
    
}
