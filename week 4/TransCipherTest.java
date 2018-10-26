public class TransCipherTest {
    public static void main(String[] args) {
        String plainText = "thisistheplaintext",
                keyText = "beauty";
        TransCipher cipher = new TransCipher(keyText);

        String cipherText = cipher.encrypt(plainText);

        System.out.printf("The cipher text of \"%s\" is \"%s\".%n", plainText, cipherText);

        String plainText2 = cipher.decrypt(cipherText);

        if(!plainText.equals(plainText2)){
            System.out.println("Decrypting does not work properly!");
        }
    }
}
