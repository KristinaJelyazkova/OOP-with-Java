import java.util.ArrayList;
import java.util.Scanner;

public class DistinctNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer number;
        ArrayList<Integer> array = new ArrayList<>();

        do{
            System.out.print("Enter a number or 0 for exit: ");
            number = in.nextInt();
            if(!array.contains(number) && number != 0){
                array.add(number);
            }
        }while(number != 0);

        System.out.println("The distinct numbers from the ones you entered are:");
        System.out.println(array.toString());
    }
}
