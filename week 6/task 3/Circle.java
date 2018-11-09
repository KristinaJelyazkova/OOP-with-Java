public class Circle extends Point {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = (radius < 0) ? 0 : radius;
    }

    public Circle(int x, int y, int radius) {
        super(x, y);
        setRadius(radius);
    }

    public Circle(Point center, int radius){
        this(center.getX(), center.getY(), radius);
    }

    public Circle(Circle other){
        this(other.getX(), other.getY(), other.radius);
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Circle){
            Circle otherPoint = (Circle) other;
            return super.equals(other)
                    && radius == otherPoint.radius;
        }
        return false;
    }

    @Override
    public boolean greater(Comparable other) {
        if(other instanceof Circle) {
            Circle otherCircle = (Circle) other;
            return super.greater(other)
                    || (radius > otherCircle.radius && super.equals(other));
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("{center = %s, radius = %d}",
                super.toString(), radius);
    }
}
