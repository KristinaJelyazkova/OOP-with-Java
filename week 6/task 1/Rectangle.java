import java.util.Random;

public class Rectangle extends Point {
    private Point lowerRightPoint;

    public Point getLowerRightPoint() {
        return new Point(lowerRightPoint);
    }

    public void setLowerRightPoint(Point lowerRightPoint) {
        this.lowerRightPoint = new Point(lowerRightPoint);
    }

    public Rectangle(int x, int y, Point lowerRightPoint) {
        super(x, y);
        setLowerRightPoint(lowerRightPoint);
    }

    public Rectangle(Point upperLeftPoint, Point lowerRightPoint) {
        this(upperLeftPoint.getX(), upperLeftPoint.getY(), lowerRightPoint);
    }

    public Rectangle(){
        this(0,0, new Point(1, 1));
    }

    public Rectangle(Rectangle other){
        this(other.getX(), other.getY(), other.lowerRightPoint);
    }

    public int measure(){
        return 2 * (lowerRightPoint.getX() - getX()
                + getY() - lowerRightPoint.getY());
    }

    @Override
    public String toString() {
        return String.format("upper left point = %s, lower right point = %s",
                super.toString(), lowerRightPoint.toString());
    }
}
