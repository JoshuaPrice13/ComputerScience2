import java.lang.Math;


public class Ramanujan {

    public static void main(String []args){

        double input = Integer.parseInt(args[0]);
        
        //find pi using Ramanujan's series
        double RamPi = calculatePI(input);
        System.out.println("\n1 divided by Ramanujan's pi using the first " + (int)input + " term(s) is:\n\t" + RamPi);
        System.out.println("1 divided by Java's pi is:\n\t" + (1/Math.PI));

        //Finding the difference
        double percent = ((1/Math.PI) - RamPi)/(1/Math.PI)*100;
        System.out.print("\nRamanujan's pi differs from Java's value by ");
        System.out.printf("%2.20f",percent);
        System.out.println("%");
    }
 
    public static double calculatePI(double i){

        double Rpi = 0;

        for(int j = 0; j<i+1;j++){
            Rpi = Rpi + ((Factorial.calculate((4 * j))) * (1103 + (26390 * (j))))/((Math.pow(Factorial.calculate(j), 4)) * Math.pow(396, (4 * j)));
        }
        Rpi =  Rpi * ((2 * (Math.sqrt(2)))/(9801));
        return Rpi;
    }

}
