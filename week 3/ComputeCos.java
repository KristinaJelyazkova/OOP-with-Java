public class ComputeCos {
    private double x;
    private double epsilon;

    public ComputeCos(double x, double epsilon) {
        this.x = x;
        this.epsilon = epsilon;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    double computeCos(){
        double currentMember = 1;
        double cos = 1;
        int i = 0;

        while(Double.compare(Math.abs(currentMember), epsilon) > 0){
            currentMember *= (Math.pow(x, 2) * (-1));
            currentMember /= ((i + 1) * (i + 2));
            i += 2;

            cos += currentMember;
        }

        return cos;
    }
}
