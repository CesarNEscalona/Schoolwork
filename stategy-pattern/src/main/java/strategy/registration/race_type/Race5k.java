package strategy.registration.race_type;

public class Race5k implements RaceType {

    @Override
    public void reward() {
        System.out.println("The winner receives: $1,000.00 for winning this 5k race");
    }
}
