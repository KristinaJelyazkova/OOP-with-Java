import java.util.Scanner;

public class CardNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a credit card number: ");
        long cardNumber = in.nextLong();

        boolean isValid = isValid(cardNumber);
        System.out.printf("The credit card number %d is %svalid.%n",
                cardNumber, isValid ? "" : "in");
    }

    public static boolean isValid(long number) {
        int numberOfDigits = getSize(number);
        if (numberOfDigits < 13 || numberOfDigits > 16) {
            return false;
        }

        long fisrtTwoDigits = getPrefix(number, 2);
        long firstDigit = fisrtTwoDigits / 10;
        if(firstDigit != 4 && firstDigit != 5 && firstDigit != 6
            && fisrtTwoDigits != 37){
            return false;
        }

        return (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0;
    }

    public static int sumOfDoubleEvenPlace(long number){
        int sum = 0;
        number /= 10;
        int digit;

        while(number > 0){
            digit = (int) (number % 10);
            digit *= 2;

            sum += getDigit(digit);

            number /= 100;
        }

        return sum;
    }

    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public  static  int getDigit(int number){
        if(number < 10){
            return number;
        }
        else{
            return number % 10 + number / 10;
        }
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number){
        int sum = 0;
        int digit;

        while(number > 0){
            digit = (int) (number % 10);
            sum += digit;

            number /= 100;
        }

        return sum;
    }

    /** Return true if the digit d is a prefix for number */
    public static boolean prefixMatched(long number, int d){
        return ( (long) d) == (getPrefix(number, 1));
    }

    /** Return the number of digits in d */
    public static int getSize(long d){
        return (int)Math.floor(Math.log10(d)) + 1;
    }

    /** Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k){
        int numberOfDigits = getSize(number);
        if(numberOfDigits < k){
            return number;
        }
        return number / (long) Math.pow(10, numberOfDigits - k);
    }

}
