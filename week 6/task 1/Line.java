public class Line extends Point{
    private Point ePoint;

    public Point getePoint() {
        return new Point(ePoint);
    }

    public void setePoint(Point ePoint) {
        this.ePoint = new Point(ePoint);
    }

    public Line(int x, int y, Point ePoint) {
        super(x, y);
        setePoint(ePoint);
    }

    public Line(Point startPoint, Point ePoint){
        this(startPoint.getX(), startPoint.getY(), ePoint);
    }

    public Line() {
        this(0,0,new Point(1, 1));
    }

    public Line(Line other) {
        this(other.getX(), other.getY(), other.ePoint);
    }

    public double measure(){
        return Math.sqrt( Math.pow(ePoint.getX() - getX(), 2)
                + Math.pow(ePoint.getY() - getY(), 2) );
    }

    @Override
    public String toString() {
        return String.format("start point = %s, end point = %s",
                super.toString(), ePoint.toString());
    }
}
