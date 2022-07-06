package model;

public class Point3D extends Point
{
    private double z;

    public Point3D(double x, double y, double z)
    {
        super(x, y);
        this.z = z;
    }

    public double getZ()
    {
        return z;
    }

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
        else if (!this.getClass().equals(obj.getClass()))
        {
            return false;
        }

        //then make a comparison based on the attributes of the Point (not the references)
        Point3D other = (Point3D)obj;
        return this.getX() == other.getX() && this.getY() == other.getY() &&
                this.z == other.z;
    }

    @Override
    public String toString()
    {
        return "Point3D{" +
                "z=" + z +
                '}';
    }
}