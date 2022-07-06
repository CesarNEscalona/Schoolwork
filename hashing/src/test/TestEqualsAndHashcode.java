package test;

import hashtables.HashTable;
import model.Point;

public class TestEqualsAndHashcode
{
    public static void main(String[] args)
    {
        HashTable<Point> pointTable = new HashTable<>();

        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 2);
        Point point3 = new Point(2, 3);

        pointTable.add(point1);
        pointTable.add(point2);
        pointTable.add(point3);

        System.out.println(pointTable.contains(point1));
        System.out.println(pointTable.contains(point2));
        System.out.println(pointTable.contains(point3));

        System.out.println(pointTable.size());
    }
}