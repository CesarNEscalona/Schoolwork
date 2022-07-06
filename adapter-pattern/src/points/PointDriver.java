package points;

public class PointDriver {

    public static void main(String[] args) {
        Cartesian2DPlane plane = new Cartesian2DPlane();

        plane.addPoint(new Point2D(3, 2));
        plane.addPoint(new Point2D(0, 5));
        plane.addPoint(new Point2D(4, 8));
        plane.addPoint(new PointAdapter(new Point3D(1, 2, 5)));
        plane.addPoint(new PointAdapter(new Point3D(4, 3, 6)));

        System.out.println(plane);


    }
}
