// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color; //Written by Eric Nguyen, nguy4911
import java.util.Scanner;

public class FractalDrawer {
    private double totalArea=0;  //member variable for tracking the total area
    //an array that contains colors, so that a new color is used for each level of the fractal
    private Color[] colors = { Color.RED, Color.WHITE, Color.BLUE, Color.RED, Color.WHITE, Color.BLUE, Color.RED, Color.WHITE, Color.BLUE,
                               Color.RED, Color.WHITE, Color.BLUE, Color.RED, Color.WHITE, Color.BLUE,};

    public FractalDrawer() {}  // contructor

    public double drawFractal(String type) {

        Canvas drawing = new Canvas(800, 800); //create a new Canvas object
        drawing.setBackground(Color.BLACK);
        
        //use the input from the user to draw the appropriate fractal, then return the total area of the fractal
        if (type.equals("circle"))
            drawCircleFractal(200, 400, 400, Color.BLUE, drawing, 8);
        else if (type.equals("triangle"))
            drawTriangleFractal(200, 200, 400, 400, Color.BLUE, drawing, 8);
        else if (type.equals("rectangle"))
            drawRectangleFractal(200, 200, 400, 400, Color.BLUE, drawing, 8);
        else 
            System.out.println("Invalid shape type. Please choose 'circle', 'triangle', or 'rectangle'.");
        return totalArea;
    }

    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        if (level <= 0){
            return;
        }

        //create a new triangle object, set a different color for it, and then draw it onto the canvas
        Triangle triangle = new Triangle(x, y, width, height);
        triangle.setColor(colors[level - 1]);
        can.drawShape(triangle);

        //use the Triangle class to calculate the area of the triangle created
        //and then add it to the totalArea
        totalArea += triangle.calculateArea();
        
        //get the new coordinates for three points on the triangle
        double topX = x + (width /4);
        double topY = y - height;
        double botLeftX = x - (width / 2);
        double botRightX = x + width;
        double botRightY = y;

        //create four new smaller triangle objects 
        drawTriangleFractal(width / 2, height / 2, botLeftX, y, c, can, level - 1);
        drawTriangleFractal(width / 2, height / 2, topX, topY, c, can, level - 1);
        drawTriangleFractal(width / 2, height / 2, botRightX, botRightY, c, can, level - 1);
    }

    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        if (level <= 0){
            return;
        }

        //create a new circle object, set a different color for it, and then draw it onto the canvas
        Circle circle = new Circle(x, y, radius);
        circle.setColor(colors[level - 1]);
        can.drawShape(circle);

        //use the Circle class to calculate the area of the circle created
        //and then add it to the totalArea
        totalArea += circle.calculateArea();

        //divide the current radius by two for the new dimensions of the circle
        double smallRadius = radius / 2;

        //get the new coordinates for four points on the circle
        double leftX = x - radius;
        double rightX = x + radius;
        double topY = y + radius;
        double lowY = y - radius;

        //create four new smaller circle objects 
        drawCircleFractal(smallRadius, leftX, y, c, can, level - 1);
        drawCircleFractal(smallRadius, rightX, y, c, can, level - 1);
        drawCircleFractal(smallRadius, x, lowY, c, can, level - 1);
        drawCircleFractal(smallRadius, x, topY, c, can, level - 1);
    }

    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        if (level <= 0){
            return;
        }

        //create a new rectangle object, set a different color for it, and then draw it onto the canvas
        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setColor(colors[level - 1]);
        can.drawShape(rectangle);

        //use the Rectangle class to calculate the area of the rectangle created
        //and then add it to the totalArea
        totalArea += rectangle.calculateArea();

        //divide the current width and height by two for the new dimensions of the new rectangles
        double smallWidth = width / 2;
        double smallHeight = height / 2;

        //get the new coordinates for the corners of the rectangle
        double topLeftX = x - (width / 2);
        double topLeftY = y - (height / 2);
        double topRightX = x + width;
        double topRightY = y - (height / 2);
        double botLeftX = x - (width / 2);
        double botLeftY = y + height;
        double botRightX = x + width;
        double botrightY = y + height;

        //create four new smaller rectangle objects 
        drawRectangleFractal(smallWidth, smallHeight, topLeftX, topLeftY, c, can, level - 1);
        drawRectangleFractal(smallWidth, smallHeight, topRightX, topRightY, c, can, level - 1);
        drawRectangleFractal(smallWidth, smallHeight, botLeftX, botLeftY, c, can, level - 1);
        drawRectangleFractal(smallWidth, smallHeight, botRightX, botrightY, c, can, level - 1);
    }
        
    public static void main(String[] args){
        FractalDrawer fractal = new FractalDrawer();
        System.out.println("Please choose a fractal type: cirlce, triangle, or rectangle ");
        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.nextLine();
        double area = fractal.drawFractal(input);
        System.out.println("The total area of the fractal is: " + area);
    }
}
