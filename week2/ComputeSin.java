public class ComputeSin {
    private double x;
    private double epsilon;

    public ComputeSin(double x, double epsilon) {
        this.x = x;
        this.epsilon = epsilon;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    double computeSin(){
        double currentMember = x;
        double sin = currentMember;
        int i = 1;

        while(Double.compare(currentMember, epsilon) > 0){
            currentMember *= (Math.pow(x, 2) * (-1));
            currentMember /= ((i + 1) * (i + 2));
            i += 2;

            sin += currentMember;
        }

        return sin;
    }
}
