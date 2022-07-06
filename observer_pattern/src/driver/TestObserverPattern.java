package driver;

import observables.Rocket;
import observers.Bystander;
import observers.Reporter;

public class TestObserverPattern
{
    public static void main(String[] args)
    {
        //create Observers
        Reporter james = new Reporter("James Jonas Jameson", "Daily Bugle");
        Reporter clark = new Reporter("Clark Kent", "Daily Planet");
        Bystander stan = new Bystander("Stan Smith", "Langley Falls");

        // create observables
        Rocket elonRocket = new Rocket("Elon 123", "Orbit");

        //elonRocket.notifyObservers();

        //attached them together
        elonRocket.addObserver(james);
        elonRocket.addObserver(clark);
        elonRocket.addObserver(stan);

        //make a change, see if the observers notice!
        elonRocket.takeOff();
        elonRocket.changeAltitude(1);
        elonRocket.changeAltitude(2);
        elonRocket.changeAltitude(3);
    }
}