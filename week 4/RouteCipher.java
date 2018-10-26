public class RouteCipher {
    private int key;
    private static final int DEFAULT_KEY = 5;
    private enum FramePart {BOTTOM_LEFT, TOP_RIGHT};
    private enum Status {ENCRYPTING, DECRYPTING};
    private Status status;

    public RouteCipher(int key) {
        setKey(key);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        if(key == 0) {
            this.key = DEFAULT_KEY;
        }
        else{
            this.key = key;
        }
    }

    public String encrypt(String plainText){
        status = Status.ENCRYPTING;

        int numberOfColumns = Math.abs(key);
        char[] plainTextChars = plainText.toCharArray();
        int maxNumberOfRows = plainTextChars.length / numberOfColumns + 1;

        char[][] matrix = new char[maxNumberOfRows][numberOfColumns];
        int numberOfRows = buildMatrix(matrix, numberOfColumns, plainTextChars);

        int matrixSize = numberOfColumns * numberOfRows;
        char[] cipherText = new char[matrixSize];

        spiralOrder(matrix, numberOfRows, numberOfColumns, cipherText);

        return new String(cipherText);
    }

    public String decrypt(String cipherText){
        status = Status.DECRYPTING;

        char[] cipherTextChars = cipherText.toCharArray();
        char[] plainText = new char[cipherTextChars.length];
        int currentIndex = 0;
        int lengthOfText = plainText.length;

        int numberOfColumns = Math.abs(key);
        int numberOfRows = cipherTextChars.length / numberOfColumns;
        char[][] matrix = new char[numberOfRows][numberOfColumns];

        spiralOrder(matrix, numberOfRows, numberOfColumns, cipherTextChars);

        for(int i = 0; i < numberOfRows; i++){
            for(int j = 0; j < numberOfColumns; j++){
                plainText[currentIndex] = matrix[i][j];
                currentIndex++;
            }
        }

        currentIndex--;
        while(plainText[currentIndex] == 'X'){
            lengthOfText--;
            currentIndex--;
        }

        return new String(plainText, 0, lengthOfText);
    }

    private void spiralOrder(char[][] matrix, int numberOfRows, int numberOfColumns, char[] cipherText){
        int currentIndex = 0; // the current index of writing in cipherText
        int currentHeight = numberOfRows;
        int currentWidth = numberOfColumns;
        int currentTopLeft = 0; // the row, which is equal to the column, of the current top left cell
        FramePart framePart = (key > 0) ? FramePart.BOTTOM_LEFT : FramePart.TOP_RIGHT;

        /* each time in the body of the cycle we read the left and the bottom part
           (or the right and the top, depending on framePart) of the outer frame of the current matrix,
           defined by its top left cell(currentTopLeft) and size(currentWidth and currentHeight),
           and we write it in the cipherText array*/
        while(currentWidth > 0 && currentHeight > 0 && currentIndex < cipherText.length){
            if(framePart == FramePart.BOTTOM_LEFT){
                currentIndex = readBottomLeft(matrix, currentTopLeft,
                        currentHeight, currentWidth, currentIndex, cipherText);
                framePart = FramePart.TOP_RIGHT;
            }
            else {
                currentIndex = readTopRight(matrix, currentTopLeft,
                        currentHeight, currentWidth, currentIndex, cipherText);
                framePart = FramePart.BOTTOM_LEFT;
            }

            /* each time we read a whole frame we "peel" it by reducing the current matrix's size
               and changing the top left cell*/
            if( (key > 0 && framePart == FramePart.BOTTOM_LEFT)
                    || (key < 0 && framePart == FramePart.TOP_RIGHT)) {
                currentTopLeft++;
                currentHeight -= 2;
                currentWidth -= 2;
            }
        }
    }



    private int readTopRight(char[][] matrix, int currentTopLeft, int currentHeight,
                             int currentWidth, int currentIndex, char[] cipherText) {
        int last = (currentWidth == 1 || currentHeight == 1) ? currentTopLeft : (currentTopLeft + 1);
        boolean hasColumnPart = (currentHeight > 1),
                hasRowPart = (currentWidth > 1);

        for(int i = currentTopLeft + currentHeight - 1; i >= last && hasColumnPart; i--){
            if(status == Status.ENCRYPTING) {
                cipherText[currentIndex++] = matrix[i][currentTopLeft + currentWidth - 1];
            }
            else{
                matrix[i][currentTopLeft + currentWidth - 1] = cipherText[currentIndex++];
            }
        }

        for(int j = currentTopLeft + currentWidth - 1; j >= last && hasRowPart; j--){
            if(status == Status.ENCRYPTING) {
                cipherText[currentIndex++] = matrix[currentTopLeft][j];
            }
            else{
                 matrix[currentTopLeft][j] = cipherText[currentIndex++];
            }
        }

        return currentIndex;
    }

    private int readBottomLeft(char[][] matrix, int currentTopLeft, int currentHeight,
                               int currentWidth, int currentIndex, char[] cipherText) {
        int lastRow = (currentWidth == 1) ? (currentTopLeft + currentHeight - 1)
                : (currentTopLeft + currentHeight - 2);
        int lastColumn = (currentHeight == 1) ? (currentTopLeft + currentWidth - 1)
                : (currentTopLeft + currentWidth - 2);
        boolean hasColumnPart = currentHeight > 1,
                hasRowPart = currentWidth > 1;

        for(int i = currentTopLeft; i <= lastRow && hasColumnPart; i++){
            if(status == Status.ENCRYPTING) {
                cipherText[currentIndex++] = matrix[i][currentTopLeft];
            }
            else{
                matrix[i][currentTopLeft] = cipherText[currentIndex++];
            }
        }

        for(int j = currentTopLeft; j <= lastColumn && hasRowPart; j++){
            if(status == Status.ENCRYPTING) {
                cipherText[currentIndex++] = matrix[currentTopLeft + currentHeight - 1][j];
            }
            else{
                matrix[currentTopLeft + currentHeight - 1][j] = cipherText[currentIndex++];
            }
        }

        return currentIndex;
    }

    // returns the number of rows which depends on the text
    private int buildMatrix(char[][] matrix, int numberOfColumns, char[] text) {
        int currentIndex = 0; // current index of reading the text
        int currentRow = 0; // current row of writing in the matrix
        int currentColumn = 0; // current column of writing in the matrix

        while(currentIndex < text.length){
            if(isNotLetter(text[currentIndex])){
                currentIndex++;
                continue;
            }

            if(currentColumn == numberOfColumns){
                currentColumn = 0;
                currentRow++;
            }

            matrix[currentRow][currentColumn] = toCapitalLetter(text[currentIndex]);
            currentIndex++;
            currentColumn++;
        }

        while(currentColumn < numberOfColumns){
            matrix[currentRow][currentColumn] = 'X';
            currentColumn++;
        }

        return currentRow + 1;
    }

    private char toCapitalLetter(char c) {
        if((int)c >= (int)'A' && (int) c <= (int)'Z'){ // if c is a capital letter
            return c;
        }
        return (char) ( (int)c + (int)'A' - (int)'a' );
    }

    private boolean isNotLetter(char c) {
        int asciiOfC = (int)c;
        int a = (int)'a',
                A = (int)'A',
                z = (int)'z',
                Z = (int)'Z';
        return !( (asciiOfC >= a && asciiOfC <= z) // not a capital letter
                || (asciiOfC >= A && asciiOfC <= Z) ); // a capital letter
    }

}
