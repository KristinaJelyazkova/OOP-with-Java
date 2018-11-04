public class HugeIntegerTest {
    public static void main(String[] args) {
        int digit[][] = { {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7},
            {1, 2, 3, 4, 5, 6, 8},
            {1, 2, 3, 4, 5, 5, 7, 8} };

        HugeInteger n[] = new HugeInteger[digit.length];

        for (int i = 0; i < digit.length; i++) {
            n[i] = new HugeInteger(digit[i]);
        }

        for (int i = 0; i < digit.length; i++) {
            System.out.printf("Number %d is %s.%n", i + 1, n[i]);
        }

        System.out.printf("The fact that %s is equal to %s is %b.%n",
                n[0], n[1], n[0].isEqualTo(n[1]));
        System.out.printf("The fact that %s is greater %s is %b.%n",
                n[1], n[2], n[1].isGreaterThan(n[2]));
        System.out.printf("The fact that %s is less than or equal to %s is %b.%n",
                n[2], n[3], n[2].isLessThanOrEqualTo(n[3]));
        System.out.printf("The fact that %s is not equal to %s is %b.%n",
                n[3], n[4], n[3].isNotEqualTo(n[4]));
    }
}
