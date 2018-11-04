public class Rational {
    private int numerator;
    private int denominator;

    public Rational(){
        this(1, 1);
    }

    public Rational(int numerator){
        this(numerator, 1);
    }

    public Rational(int numerator, int denominator) {
        setRational(numerator, denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setRational(int numerator, int denominator){
        if(denominator < 0){
            denominator = -denominator;
            numerator = -numerator;
        }

        denominator = (denominator == 0) ? 1 : denominator;

        int biggestCommonDivisor = biggestCommonDivisor(Math.abs(numerator), denominator);

        this.numerator = numerator / biggestCommonDivisor;
        this.denominator = denominator / biggestCommonDivisor;
    }

    private int biggestCommonDivisor(int x, int y) {
        if(x < y){
            int swap = x;
            x = y;
            y = swap;
        }

        if(y == 0){
            return x;
        }

        return biggestCommonDivisor(x % y, y);
    }

    public void setNumerator(int numerator) {
        setRational(numerator, denominator);
    }


    public void setDenominator(int denominator) {
        setRational(numerator, denominator);
    }

    public String toString(){
        return String.format("%d/%d", numerator, denominator);
    }

    public Rational add(Rational other){
        int numerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int denominator = this.denominator * other.denominator;

        return new Rational(numerator, denominator);
    }

    public Rational subtract(Rational other){
        int numerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int denominator = this.denominator * other.denominator;

        return new Rational(numerator, denominator);
    }

    public Rational multiply(Rational other){
        int numerator = this.numerator * other.numerator;
        int denominator = this.denominator * other.denominator;

        return new Rational(numerator, denominator);
    }

    public Rational divide(Rational other){
        int numerator = this.numerator * other.denominator;
        int denominator = this.denominator * other.numerator;

        return new Rational(numerator, denominator);
    }
}
