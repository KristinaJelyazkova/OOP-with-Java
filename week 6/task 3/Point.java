public class Point extends Shape {
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

    public Point(int x, int y) {
        setX(x);
        setY(y);
    }

    public Point(Point other){
        this(other.x, other.y);
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Point){
            Point otherPoint = (Point) other;
            return x == otherPoint.x && y == otherPoint.y;
        }
        return false;
    }

    @Override
    public boolean greater(Comparable other) {
        if(other instanceof Point){
            Point otherPoint = (Point) other;
            return (x > otherPoint.x)
                    || (x == otherPoint.x && y > otherPoint.y);
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
