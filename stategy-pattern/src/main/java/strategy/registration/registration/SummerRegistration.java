package strategy.registration.registration;

import entities.Runner;

import java.util.Set;

// This is a ConcreteStrategy
public class SummerRegistration implements IRegistration{

    @Override
    public Set<Runner> filterRunners(Set<Runner> runners) {
        return null;
    }
}
