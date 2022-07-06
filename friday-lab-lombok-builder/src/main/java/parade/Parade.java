package parade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class Parade {

    private String paradeName;
    private LocalDate date;
    private int numFloats;
    private boolean securityProvided;
    private int audienceAttended;
}
