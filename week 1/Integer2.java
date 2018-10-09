// Decrypting a four-digit number
import java.util.Scanner;

public class Integer2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int originalNumber;
        int[] digit = new int[4];
        int encryptedNumber;
        int temp;

        System.out.print("Enter a 4-digit number: ");
        encryptedNumber = in.nextInt();

        if(encryptedNumber <= 999 || encryptedNumber >= 10000){ // checking if the input is a 4-digit number
            System.err.println("Error! The number does not have 4 digits!");
            return;
        }

        for (int i = 0; i < 4; i++) { // separating digits
            digit[i] = encryptedNumber % 10;
            encryptedNumber /= 10;
        }

        // swapping the digits
        temp = digit[1];
        digit[1] = digit[3];
        digit[3] = temp;

        temp = digit[0];
        digit[0] = digit[2];
        digit[2] = temp;

        for (int i = 0; i < 4; i++) { // decrypting digits of the original number
            digit[i] -= 7;
            if(digit[i] < 0){
                digit[i] += 10;
            }
        }

        // calculating the original number from its digits
        originalNumber = digit[0] + digit[1] * 10 + digit[2] * 100 + digit[3] * 1000;

        System.out.printf("The original number is %d.\n", originalNumber);
    }
}
