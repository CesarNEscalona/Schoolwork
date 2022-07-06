package race;

import strategy.registration.registration.IRegistration;
import strategy.registration.race_type.RaceType;
import java.time.LocalDate;

public class RewardRace extends Race{

    private RaceType raceType;

    public RewardRace(String name, LocalDate dayOfRace, IRegistration registration, RaceType raceType) {
        super(name, dayOfRace, registration);
        this.raceType = raceType;
    }

    public void reward(){
        raceType.reward();
    }
}
