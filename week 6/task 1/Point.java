public class Point {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void set(Point point){
        setX(point.x);
        setY(point.y);
    }

    public Point get(){
        return new Point(x,y);
    }

    public Point(int x, int y) {
        setX(x);
        setY(y);
    }

    public Point(){
        this(0,0);
    }

    public Point(Point other){
        this(other.x, other.y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
