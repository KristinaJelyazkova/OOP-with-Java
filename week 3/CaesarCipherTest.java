import java.util.Scanner;

public class CaesarCipherTest {
    public static void main(String[] args) {
        System.out.println("Enter 1 or 2 for the following options:");
        System.out.println("1. Cipher text");
        System.out.println("2. Decipher text");

        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        switch(choice){
            case 1:
                System.out.print("Enter the plain text: ");
                String plainText = in.next();
                System.out.printf("The ciphered text is %s.%n",
                        CaesarCipher.cipher(plainText));
                break;
            case 2:
                System.out.print("Enter the ciphered text: ");
                String cipherText = in.next();
                System.out.printf("The deciphered text is %s.%n",
                        CaesarCipher.decipher(cipherText));
                break;
                default:
                    System.out.println("Wrong usage! Enter 1 or 2.");
        }
    }
}
