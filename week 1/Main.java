import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number;
        int maxSize = 7; // the maximum length of the string that the number represents
        int[] k = new int[maxSize]; // an array for storing k0, k1, k2... from the formula
        int i = 0;

        System.out.print("Enter a four-digit number: ");
        number = in.nextInt();

        // checking the input
        if(number <= 999 || number >= 10000){
            System.err.println("Error! The number does not have 4 digits!");
            return;
        }

        // calculating the values of k0, k1... using the formula
        while(number > 0) {
            k[i] = number % 4;
            number /= 4;
            i++;
        }

        System.out.print("The number represents ");

        // converting numbers into letters
        for (int j = i - 1; j >= 0; j--) {
            switch(k[j]){
                case 0: System.out.print('A'); break;
                case 1: System.out.print('C'); break;
                case 2: System.out.print('G'); break;
                case 3: System.out.print('T'); break;
            }
        }

        System.out.println();
    }
}
