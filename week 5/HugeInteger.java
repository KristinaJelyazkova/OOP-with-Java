public class HugeInteger {
    private final int MAX_NUMBER_OF_DIGITS = 40;
    private int digit[];
    private int digitCount;


    public HugeInteger(int[] digit) {
        setDigit(digit);
    }

    public HugeInteger(){
        this.digit = new int[1];
        digit[0] = 0;
        digitCount = 1;
    }

    public HugeInteger(HugeInteger other){
        this(other.digit);
    }

    public int[] getDigit() {
        return digit;
    }

    public void setDigit(int[] digit) {
        digitCount = digit.length;
        this.digit = new int[MAX_NUMBER_OF_DIGITS];

        for (int i = 0; i < digit.length && i < MAX_NUMBER_OF_DIGITS; i++) {
            this.digit[i] = digit[i];
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder();

        for (int i = digitCount - 1; i >= 0; i--) {
            result.append(digit[i]);
        }

        return result.toString();
    }

    public boolean isEqualTo(HugeInteger other){
        if(digitCount != other.digitCount){
            return false;
        }

        for (int i = 0; i < digitCount; i++) {
            if(digit[i] != other.digit[i]){
                return false;
            }
        }

        return true;
    }

    public boolean isNotEqualTo(HugeInteger other){
        return !isEqualTo(other);
    }

    public boolean isGreaterThan(HugeInteger other){
        if(digitCount != other.digitCount){
            return digitCount > other.digitCount;
        }

        for (int i = digitCount; i >= 0; i--) {
            if(digit[i] != other.digit[i]){
                return digit[i] > other.digit[i];
            }
        }

        return false;
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger other){
        return isGreaterThan(other) || isEqualTo(other);
    }

    public boolean isLessThan(HugeInteger other){
        return !isGreaterThanOrEqualTo(other);
    }

    public boolean isLessThanOrEqualTo(HugeInteger other){
        return !isGreaterThan(other);
    }

    public boolean isZero(){
        return digitCount == 1 && digit[0] == 0;
    }
}
