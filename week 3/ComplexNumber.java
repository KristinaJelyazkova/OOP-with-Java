import java.awt.*;

public class ComplexNumber {
    private double imaginaryPart;
    private double realPart;


    public ComplexNumber(double imaginaryPart, double realPart) {
        this.imaginaryPart = imaginaryPart;
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getAngle(){
        return Math.atan2(imaginaryPart, realPart);
    }

    public double getMagnitude(){
        return Math.sqrt( Math.pow(realPart, 2)
                + Math.pow(imaginaryPart, 2) );
    }

    public ComplexNumber add(ComplexNumber otherNumber){
        return new ComplexNumber(imaginaryPart + otherNumber.imaginaryPart,
                realPart + otherNumber.realPart);
    }
}
