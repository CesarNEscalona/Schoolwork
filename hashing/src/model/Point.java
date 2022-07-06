package model;

public class Point
{
    private double x, y;

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    /*
     * Reflexive (a.equals(a) always)
     * Symmetric (a.equals(b) -> b.equals(a))
     * Transitive (a.equals(b) && b.equals(c) -> a.equals(c))
     * Consistent
     * a.equals(null) always false
     */
    @Override
    public boolean equals(Object obj)
    {
        //first we need to determine if the parameter is a Point
        if (this == obj)
        {
            return true;
        }
        else if (obj == null)
        {
            return false;
        }
        else if (!this.getClass().equals(obj.getClass())) //Is this a Point object?
        {
            return false;
        }

        //then make a comparison based on the attributes of the Point (not the references)
        Point other = (Point)obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode()
    {
        return (int)(x * y);
    }

    @Override
    public String toString()
    {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}