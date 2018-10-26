import java.util.Scanner;

public class RouteCipherTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int key;
        String plainText = "abort the mission, you have been spotted";
        String cipherText;

        System.out.print("Enter a key(a signed integer): ");
        key = in.nextInt();

        RouteCipher cipher = new RouteCipher(key);
        cipherText = cipher.encrypt(plainText);

        System.out.println("The cipher text is " + cipherText);

        // -----------------------------------------------------

        String cipherText2 = "TIEIXTXXEAHSIHSPNTLT";

        cipher.setKey(4);
        String plainText2 = cipher.decrypt(cipherText2);

        System.out.println("The plain text is " + plainText2);
    }
}
