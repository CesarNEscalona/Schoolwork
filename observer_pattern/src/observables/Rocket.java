package observables;

public class Rocket extends Observable
{
    private String name;
    private String destination;
    private int altitude; //in miles

    public Rocket(String name, String destination)
    {
        this.name = name;
        this.destination = destination;
    }

    public String getName()
    {
        return name;
    }

    public String getDestination()
    {
        return destination;
    }

    public int getAltitude()
    {
        return altitude;
    }

    public void takeOff()
    {
        //do something...
        notifyObservers(this, "Takeoff");

    }

    public void changeAltitude(int miles)
    {
        altitude = miles;

        notifyObservers(this, miles);
    }
}