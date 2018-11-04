public class RationalTest {
    public static void main(String[] args) {
        Rational r1 = new Rational(30, 12);
        Rational r2 = new Rational(48, 100);

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);

        System.out.println("r1 + r2 = " + r1.add(r2));
        System.out.println("r1 - r2 = " + r1.subtract(r2));
        System.out.println("r1 * r2 = " + r1.multiply(r2));
        System.out.println("r1 / r2 = " + r1.divide(r2));
    }
}
