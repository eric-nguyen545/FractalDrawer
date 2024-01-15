import java.awt.Color; //Written by Eric Nguyen, nguy4911

public class Triangle{
    private double XPosBotLeft;
    private double YPosBotLeft;
    private double width;
    private double height;
    private Color triangleColor;

    public Triangle(double initXPosBotLeft, double initYPosBotLeft, double initWidth, double initHeight) {
        this.XPosBotLeft = initXPosBotLeft;
        this.YPosBotLeft = initYPosBotLeft;
        this.width = initWidth;
        this.height = initHeight;
        this.triangleColor = Color.BLACK;
    }
    
    public double calculatePerimeter() {
        double trianglePerimeter = width + Math.sqrt(((width * width) + (4 * (height * height))));
        return trianglePerimeter;
    }

    public double calculateArea() {
        double triangleArea = (width * height) / 2;
        return triangleArea;
    }

    public void setColor(Color newTriangleColor){
        triangleColor = newTriangleColor;
    }

    public void setPos(double newXPosBotLeft, double newYPosBotLeft) {
        XPosBotLeft = newXPosBotLeft;
        YPosBotLeft = newYPosBotLeft;
    }

    public void setHeight(double newHeight) {
        height = newHeight;
    }

    public void setWidth(double newWidth) {
        width = newWidth;
    }

    public Color getColor() {
        return triangleColor;
    }

    public double getXPos() {
        return XPosBotLeft;
    }

    public double getYPos() {
        return YPosBotLeft;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
    
}