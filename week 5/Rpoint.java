import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.awt.*;

public class Rpoint{
    private double r;
    private double theta;

    public Rpoint(double r, double theta) {
        this.r = r;
        this.theta = theta;
    }

    public double[] toCartesian(){
        double[] cartesian = new double[2];
        cartesian[0] = r * Math.cos(theta);
        cartesian[1] = r * Math.sin(theta);

        return cartesian;
    }

    public double distanceTo(Rpoint other){
        double d1 = r * Math.cos(theta) - other.r * Math.cos(other.theta),
                d2 = r * Math.sin(theta) - other.r * Math.sin(other.theta);

        return Math.sqrt(Math.pow(d1, 2) + Math.pow(d2, 2));
    }

    public void drawLine(Group pane, Rpoint toPoint){
        double[] cartesianFrom = toCartesian(),
                cartesianTo = toPoint.toCartesian();
        Line line = new Line(cartesianFrom[0], cartesianFrom[1],
                cartesianTo[0], cartesianTo[1]);
        line.setStroke(Color.BLUE);
        line.setStrokeWidth(2);

        pane.getChildren().add(line);
    }
}
