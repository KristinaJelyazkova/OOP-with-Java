public class Cylinder extends Circle {
    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = (height < 0) ? 0 : height;
    }

    public Cylinder(int x, int y, int radius, int height) {
        super(x, y, radius);
        setHeight(height);
    }

    public Cylinder(Circle circle, int height){
        this(circle.getX(), circle.getY(), circle.getRadius(), height);
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Cylinder){
            Cylinder otherCylinder = (Cylinder) other;
            return super.equals(other)
                    && height == otherCylinder.height;
        }
        return false;
    }

    @Override
    public boolean greater(Comparable other) {
        if(other instanceof Cylinder){
            Cylinder otherCylinder = (Cylinder) other;
            return super.greater(other)
                    || (height > otherCylinder.height && super.equals(other));
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("circle: %s%nheight = %d",
                super.toString(), height);
    }
}
