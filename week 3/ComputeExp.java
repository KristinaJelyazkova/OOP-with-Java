public class ComputeExp {
    private double x;
    private int terms;

    public ComputeExp(double x, int terms) {
        this.x = x;
        this.terms = terms;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    double computeExp(){
        double currentMember = x;
        double exp = 1 + currentMember;
        int i = 1, counter  = 0;

        while(counter < terms){
            currentMember *= x;
            currentMember /= (i + 1);
            i++;

            exp += currentMember;
            counter++;
        }

        return exp;
    }
}
