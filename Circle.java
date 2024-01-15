import java.awt.Color; //Written by Eric Nguyen, nguy4911

public class Circle{
    double XPos;
    double YPos;
    double radius;
    Color circleColor;

    public Circle(double initXPos, double initYPos, double initRadius) { // Constructor
        this.XPos = initXPos;
        this.YPos = initYPos;
        this.radius = initRadius;
        this.circleColor = Color.BLACK;

    }

    public double calculatePerimeter() {
        double circlePerimeter = Math.PI * radius * radius;
        return circlePerimeter;
    }

    public double calculateArea() {
        double circleArea = 2 * Math.PI * (radius * radius);
        return circleArea;
    }

    public void setColor(Color newCircleColor) {
        circleColor = newCircleColor;
        
    }

    public void setPos(double newXPos, double newYPos) {
        XPos = newXPos;
        YPos = newYPos;
    }
    
    public void setRadius(double newRadius) {
        radius = newRadius;

    }

    public Color getColor() {
        return circleColor;
    }

    public double getXPos() {
        return XPos;
    }

    public double getYPos() {
        return YPos;
    }

    public double getRadius() {
        return radius;
    }
}
