public class CaesarCipher {
    private final static char LETTERS[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private final static int LETTERS_SIZE = 26;
    private final static int SHIFT_LENGTH = 3;

    public static String cipher(String plainText){
        char result[] = plainText.toCharArray();

        for (int i = 0; i < result.length; i++) {
            result[i] = LETTERS[ (toInt(result[i]) + SHIFT_LENGTH) % LETTERS_SIZE ];
        }

        return new String(result);
    }

    public static String decipher(String cipherText){
        char result[] = cipherText.toCharArray();

        for (int i = 0; i < result.length; i++) {
            result[i] = LETTERS[ (toInt(result[i]) - SHIFT_LENGTH + LETTERS_SIZE) % LETTERS_SIZE ];
        }

        return new String(result);
    }

    public static int toInt(char symbol){
        for (int i = 0; i < LETTERS_SIZE; i++) {
            if(symbol == LETTERS[i]){
                return i;
            }
        }
        return -1;
    }
}
