public class Probability {
    private int FIRST_DIGIT_FROM = 3;
    private int FIRST_DIGIT_TO = 9;
    private int SECOND_DIGIT_FROM = 2;
    private int SECOND_DIGIT_TO = 8;
    private int THIRD_DIGIT_FROM = 4;
    private int THIRD_DIGIT_TO = 9;
    private int FOURTH_DIGIT_FROM = 1;
    private int FOURTH_DIGIT_TO = 6;
    private int FIFTH_DIGIT_FROM = 6;
    private int FIFTH_DIGIT_TO = 9;

    public int allNumbers(){
        return (FIRST_DIGIT_TO - FIFTH_DIGIT_FROM + 1)
                * (SECOND_DIGIT_TO - SECOND_DIGIT_FROM + 1)
                * (THIRD_DIGIT_TO - THIRD_DIGIT_FROM + 1)
                * (FOURTH_DIGIT_TO - FOURTH_DIGIT_FROM + 1)
                * (FIFTH_DIGIT_TO - FIFTH_DIGIT_FROM + 1);
    }

    public int numbersDivisibleBy12(){
        int counter = 0;

        for(int firstDigit = FIRST_DIGIT_FROM; firstDigit <= FIRST_DIGIT_TO; firstDigit++){
            for(int secondDigit = SECOND_DIGIT_FROM; secondDigit <= SECOND_DIGIT_TO; secondDigit++) {
                for (int thirdDigit = THIRD_DIGIT_FROM; thirdDigit <= THIRD_DIGIT_TO; thirdDigit++) {
                    for (int fourthDigit = FOURTH_DIGIT_FROM; fourthDigit <= FOURTH_DIGIT_TO; fourthDigit++) {
                        for (int fifthDigit = FIFTH_DIGIT_FROM; fifthDigit <= FIFTH_DIGIT_TO; fifthDigit++) {
                                if(isDivisibleBy3(firstDigit, secondDigit, thirdDigit, fourthDigit, fifthDigit)
                                    && isDivisibleBy4(fourthDigit, fifthDigit)){
                                    counter++;
                                }
                        }
                    }
                }
            }
        }

        return counter;
    }

    public double probability(){
        return (double) numbersDivisibleBy12() / allNumbers();
    }

    private boolean isDivisibleBy3(int firstDigit, int secondDigit, int thirdDigit, int fourthDigit, int fifthDigit){
        return (firstDigit + secondDigit + thirdDigit + fourthDigit + fifthDigit) % 3 == 0;
    }

    private boolean isDivisibleBy4(int fourthDigit, int fifthDigit){
        return (fifthDigit + 10 * fourthDigit) % 4 == 0;
    }
}
