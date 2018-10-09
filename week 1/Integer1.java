// Encrypting a four-digit number
import java.util.Scanner;

public class Integer1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int originalNumber;
        int[] digit = new int[4];
        int encryptedNumber;

        System.out.print("Enter a 4-digit number: ");
        originalNumber = in.nextInt();

        if(originalNumber <= 999 || originalNumber >= 10000){ // checking if the input is a 4-digit number
            System.err.println("Error! The number does not have 4 digits!");
            return;
        }

        for (int i = 0; i < 4; i++) { // separating digits of the original number and encrypting them
            digit[i] = originalNumber % 10;
            originalNumber /= 10;
            digit[i] = (digit[i] + 7) % 10;
        }

        // swapping the digits and calculating the encrypted number
        encryptedNumber = digit[2] + digit[3] * 10 + digit[0] * 100 + digit[1] * 1000;

        System.out.printf("The encrypted number is %d.\n", encryptedNumber);
    }
}
