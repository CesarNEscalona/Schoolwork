package strategy.registration.registration;

import entities.Runner;
import java.util.Set;

public interface IRegistration {
    Set<Runner> filterRunners(Set<Runner> runners);
}
