import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;

public class Line{
    private Point sPoint;
    private Point ePoint;

    public Point getsPoint() {
        return sPoint;
    }

    public void setsPoint(Point sPoint) {
        this.sPoint = new Point(sPoint);
    }

    public Point getePoint() {
        return ePoint;
    }

    public void setePoint(Point ePoint) {
        this.ePoint = new Point(ePoint);
    }

    public Line(Point sPoint, Point ePoint) {
        setsPoint(sPoint);
        setePoint(ePoint);
    }

    public Line(){
        this(new Point(0,0), new Point(20,20));
    }

    public Line(Line other){
        this(other.sPoint, other.ePoint);
    }

    public void draw(Group pane){
        javafx.scene.shape.Line line = new javafx.scene.shape.Line(sPoint.getX(), sPoint.getY(),
                ePoint.getX(), ePoint.getY());
        line.setStroke(Color.BLUE);
        line.setStrokeWidth(2);

        pane.getChildren().add(line);
    }

    @Override
    public String toString() {
        return String.format("start point = %s, end point = %s",
                sPoint.toString(), ePoint.toString());
    }
}
