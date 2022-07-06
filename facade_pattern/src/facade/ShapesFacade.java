package facade;

import shapes.basic.*;
import shapes.specific.Circle;
import shapes.specific.Point;
import shapes.specific.Square;
import subsystems.ShapeDimensions;

public class ShapesFacade {

    public BaseShape generateShape(ShapeType type, double param1){
        switch (type)
        {
            case SQUARE:
                return new Square(param1);
            case CIRCLE:
                return new Circle(param1);
        }
        throw new IllegalStateException("Shape not found with one parameter");
    }

    public BaseShape generateShape(ShapeType type, double param1, double param2){
        switch (type)
        {
            case RECTANGLE:
                return new Rectangle(param1, param2);
            case POINT:
                return new Point(param1, param2);
            case ELLIPSE:
                return new Ellipse(param1, param2);
        }
        throw new IllegalStateException("Shape not found with 2 parameters");
    }

    public BaseShape generateShape(ShapeType type, double param1, double param2,
                                   double param3, double param4){
        switch (type)
        {
            case LINE:
                return new Line(param1, param2, param3, param4);
        }
        throw new IllegalStateException("Shape not found with 4 parameters");
    }

    // report out an area of a shape, should be easier to use than shape dimensions
    public double calculateArea(BaseShape shape){
        ShapeDimensions calculate = new ShapeDimensions();

        switch (shape.getType())
        {
            case RECTANGLE:
                return calculate.rectangleArea((Rectangle) shape);
            case ELLIPSE:
                return calculate.ellipseArea((Ellipse) shape);
        }
        throw new IllegalStateException("Shape not found");
    }
}
