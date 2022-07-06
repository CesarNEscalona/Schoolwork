package strategy.registration.race_type;

public class Race10k implements RaceType {

    @Override
    public void reward() {
        System.out.println("The winner receives: A Vacation Package for winning this 10k race");
    }
}
