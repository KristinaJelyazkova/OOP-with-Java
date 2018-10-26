public class TransCipher {
    private int key;
    private static final int DEFAULY_KEY = 5;
    private enum Status {ENCRYPTING, DECRYPTING};
    private Status status;

    public TransCipher(String keyText) {
        setKey(keyText);
        status = Status.ENCRYPTING;
    }

    public void setKey(String keyText) {
        int key = keyText.toCharArray().length;
        this.key = key > 0 ? key : DEFAULY_KEY;
    }

    public String encrypt(String plainText){
        status = Status.ENCRYPTING;
        return crypt(plainText);
    }

    public String decrypt(String cipherText){
        status = Status.DECRYPTING;
        return crypt(cipherText);
    }

    public String crypt(String text){
        char[] plainTextChars = text.toCharArray();
        int numberOfColumns = key;
        int length = plainTextChars.length;
        int numberOfRows = plainTextChars.length / key;
        if(length % key != 0){
            numberOfRows++;
        }
        char[][] matrix = new char[numberOfRows][numberOfColumns];

        buildMatrix(matrix, plainTextChars);
        String resultText = readMatrix(matrix);

        return resultText;
    }

    private String readMatrix(char[][] matrix) {
        int endI = matrix[0].length,
            endJ = matrix.length;

        if(status == Status.DECRYPTING){
            endI = matrix.length;
            endJ = matrix[0].length;
        }
        char[] resultText = new char[endI * endJ];
        int currentIndex = 0;

        for(int i = 0; i < endI; i++){
            for(int j = 0; j < endJ; j++){
                if(status == Status.ENCRYPTING) {
                    resultText[currentIndex++] = matrix[j][i];
                }
                else{
                    resultText[currentIndex++] = matrix[i][j];
                }
            }
        }

        currentIndex--;

        if(status == Status.DECRYPTING){
            while(resultText[currentIndex] == ' '){
                currentIndex--;
            }
        }

        return new String(resultText, 0, currentIndex + 1);
    }

    private void buildMatrix(char[][] matrix, char[] text) {
        int currentIndex = 0;
        int endI = matrix.length,
                endJ = matrix[0].length;

        if(status == Status.DECRYPTING){
            endI = matrix[0].length;
            endJ = matrix.length;
        }

        for (int i = 0; i < endI; i++) {
            for (int j = 0; j < endJ; j++) {
                if(status == Status.ENCRYPTING) {
                    if (currentIndex < text.length) {
                        matrix[i][j] = text[currentIndex++];
                    } else {
                        matrix[i][j] = ' ';
                    }
                }
                else{
                    matrix[j][i] = text[currentIndex++];
                }
            }
        }
    }
}
