import javafx.scene.Group;
import javafx.scene.paint.Color;
import org.w3c.dom.css.Rect;

public class Rectangle{
    private Point uPoint;
    private double width;
    private double height;

    public Point getuPoint() {
        return new Point(uPoint);
    }

    public void setuPoint(Point uPoint) {
        this.uPoint = new Point(uPoint);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Rectangle(Point uPoint, double width, double height) {
        setuPoint(uPoint);
        setWidth(width);
        setHeight(height);
    }

    public Rectangle(){
        this(new Point(0,0), 20, 20);
    }

    public Rectangle(Rectangle other){
        this(other.uPoint, other.width, other.height);
    }

    public void draw(Group pane){
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(uPoint.getX(), uPoint.getY(), width, height);
        rectangle.setStroke(Color.BLUE);
        rectangle.setFill(Color.WHITE);
        rectangle.setStrokeWidth(2);

        pane.getChildren().add(rectangle);
    }

    public String toString(){
        return String.format("upper left corner = %s, width = %.2f, height = %.2f",
                uPoint.toString(), width, height);
    }
}
