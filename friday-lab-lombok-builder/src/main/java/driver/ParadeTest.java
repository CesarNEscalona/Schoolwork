package driver;

import parade.Parade;
import java.time.LocalDate;

public class ParadeTest {
    public static void main(String[] args) {

        Parade myParade = Parade.builder()
                .paradeName("PartyTime")
                .date(LocalDate.now())
                .numFloats(5)
                .securityProvided(true)
                .audienceAttended(200)
                .build();

        System.out.println(myParade);
    }
}
