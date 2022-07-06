package test;

import entities.Document;
import entities.Runner;
import race.RewardRace;
import strategy.registration.race_type.Race10k;
import strategy.registration.race_type.Race20k;
import strategy.registration.race_type.Race5k;
import strategy.registration.registration.OpenRegistration;
import java.time.LocalDate;
import java.util.Arrays;

public class RaceTest {
    public static void main(String[] args) {
        Runner[] runners = {
                new Runner("Stan Williams", Arrays.asList(new Document("Winter Registration"))),
                new Runner("Michelle Smith", Arrays.asList(new Document("Fall Registration"),
                        new Document("Liability Waiver"))),
                new Runner("Tyler Patrick", Arrays.asList(new Document("Winter Registration"),
                        new Document("Liability Waiver"))),
                new Runner("Jean Davis", Arrays.asList(new Document("Winter Registration"),
                        new Document("Liability Waiver"))),
                new Runner("Susie Brown", Arrays.asList(new Document("Fall Registration"))),
                new Runner("Terry Wilson", Arrays.asList(new Document("Fall Registration"),
                        new Document("Liability Waiver")))
        };

        RewardRace race5k = new RewardRace("5k race",
                LocalDate.of(22, 7, 20),
                new OpenRegistration(), new Race5k());
        Arrays.stream(runners).forEach(runner -> race5k.register(runner));
        race5k.raceDay();
        race5k.reward();
        System.out.println();

        RewardRace race10k = new RewardRace("10k race",
                LocalDate.of(22, 6, 10),
                new OpenRegistration(), new Race10k());
        Arrays.stream(runners).forEach(runner -> race10k.register(runner));
        race10k.raceDay();
        race10k.reward();
        System.out.println();

        RewardRace race20k = new RewardRace("20k race",
                LocalDate.of(22, 12, 25),
                new OpenRegistration(), new Race20k());
        Arrays.stream(runners).forEach(runner -> race20k.register(runner));
        race20k.raceDay();
        race20k.reward();
    }
}
