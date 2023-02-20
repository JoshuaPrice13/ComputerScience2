import java.util.ArrayList;

public class Fib {
    public static void main (String[] args){

        //grabs the input from the cmd and parses it to an int
        int input = 6;//Integer.parseInt(args[0]);

        //Using ArrayList to add Fibonacci numbers
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(1);

        int indexCounter = 2;

        //loops the formula for Fibonacci's numbers n amount of times
        for(int i = 1; i<input;i++){
            list1.add(list1.get(indexCounter-2)+list1.get(indexCounter-1));
            indexCounter++;
        }
        
        //prints the nth number of the ArrayList that the user inputed in the cmd
        System.out.println(list1.get(indexCounter-1));
    }
}
