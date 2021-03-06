package observables;

import observers.IObserver;
import java.util.HashSet;
import java.util.Set;

/**
 * This is meant to be the parent class of observable objects
 * (objects that do something that is interesting).
 */
public abstract class Observable
{
    private Set<IObserver> observers;

    public Observable()
    {
        observers = new HashSet<>();
    }

    //track observers
    public void addObserver(IObserver observer)
    {
        //because this is a set, duplicate observers will be ignored
        observers.add(observer);
    }

    public void removeObserver(IObserver observer)
    {
        observers.remove(observer);
    }

    //let observers know that the observable "did something"
    protected void notifyObservers()
    {
        //loop over all observers
        for (IObserver observer : observers)
        {
            observer.update();
        }
    }

    protected void notifyObservers(Object... args)
    {
        //loop over all observers
        for (IObserver observer : observers)
        {
            observer.update(args);
        }
    }
}