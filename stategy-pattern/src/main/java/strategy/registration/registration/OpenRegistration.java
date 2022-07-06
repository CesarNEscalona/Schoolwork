package strategy.registration.registration;

import entities.Runner;
import java.util.Set;


public class OpenRegistration implements IRegistration {

    @Override
    public Set<Runner> filterRunners(Set<Runner> runners) {

        return runners;
    }
}
