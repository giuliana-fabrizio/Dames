package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ViewCircle extends Circle {

    public ViewCircle(double posX, double posY, double radius, Color color) {
        super(posX, posY, radius, color);
    }

    public double getX(double x) {
        return (x/25-1)/2;
    }

    public double getY(double x) {
        return (x/25-1)/2;
    }
}
