package secretchars;

import java.util.Arrays;

public class Result {
    private char[] chars;
    private int data;

    public char[] getChars() {
        return Arrays.copyOf(chars, chars.length);
    }

    public void setChars(char[] chars) {
        this.chars = Arrays.copyOf(chars, chars.length);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = (data > 0) ? data : 0;
    }

    public Result(char[] chars, int data) {
        setChars(chars);
        setData(data);
    }

    @Override
    public String toString() {
        return String.format("Chars = %s%nResult = %d%n",
                Arrays.toString(chars), data);
    }
}
