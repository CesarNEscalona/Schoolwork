package strategy.registration.race_type;

public class Race20k implements RaceType {

    @Override
    public void reward() {
        System.out.println("The winner receives: $5,000.00 for winning this 20k race");
    }
}
