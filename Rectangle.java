import java.awt.Color; //Written by Eric Nguyen, nguy4911

public class Rectangle{
    private double XPosUpLeft;
    private double YPosUpLeft;
    private double width;
    private double height;
    private Color rectangleColor;

    public Rectangle(double initXPosUpLeft, double initYPosUpLeft, double initWidth, double initHeight) {
        this.XPosUpLeft = initXPosUpLeft;
        this.YPosUpLeft = initYPosUpLeft;
        this.width = initWidth;
        this.height = initHeight;
        this.rectangleColor = Color.BLACK;
    }
    
    public double calculatePerimeter() {
        double rectanglePerimeter = (2* width) + (2 * height);
        return rectanglePerimeter;
    }

    public double calculateArea() {
        double rectangleArea = width * height;
        return rectangleArea;
    }

    public void setColor(Color newRectangleColor) {
        rectangleColor = newRectangleColor;
    }

    public void setPos(double newXPosBotLeft, double newYPosBotLeft) {
        XPosUpLeft = newXPosBotLeft;
        YPosUpLeft = newYPosBotLeft;
    }

    public void setHeight(double newHeight) {
        height = newHeight;
    }

    public void setWidth(double newWidth) {
        width = newWidth;
    }

    public Color getColor() {
        return rectangleColor;
    }

    public double getXPos() {
        return XPosUpLeft;
    }

    public double getYPos() {
        return YPosUpLeft;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
    
}