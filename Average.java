import java.util.Scanner;

public class Average {
    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);

        int counter = 0;
        int total = 0;

        System.out.println("/n Enter a series of numbers. Enter a negative number to quit./n");
        int user_number = scan.nextInt();
        
        while(user_number >= 0){
            counter++;
            total = total + user_number;
            user_number = scan.nextInt();
        }
        if(user_number < 0){
            counter++;
            total = total + user_number;
            System.out.println("You have entered " + counter + " numbers, averaging " + total/counter );
        }  
    }
}
