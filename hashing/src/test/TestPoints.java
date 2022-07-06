package test;

import model.Point;
import model.Point3D;

public class TestPoints
{
    public static void main(String[] args)
    {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 2);

        //a.equals(a) should always be true
        System.out.println(point1.equals(point1));
        System.out.println();

        //if both are true, then .equals() is symmetric
        System.out.println(point1.equals(point2));
        System.out.println(point2.equals(point1));
        System.out.println();

        Point point3 = new Point(2, 3);
        System.out.println(point2.equals(point3));
        System.out.println(point3.equals(point2));
        System.out.println();

        Point3D point4 = new Point3D(1, 2, 3);
        System.out.println(point1.equals(point4));
        System.out.println(point4.equals(point1));
        System.out.println();

        //is the equals() method transitive
        Point point5 = new Point(1, 2);
        System.out.println(point1.equals(point2));
        System.out.println(point2.equals(point5));
        System.out.println(point1.equals(point5));
    }
}