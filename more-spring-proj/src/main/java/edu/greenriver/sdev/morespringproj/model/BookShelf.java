package edu.greenriver.sdev.morespringproj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component   // this makes a Spring bean instance for BookShelf
public class BookShelf {
    private String material;
    private boolean fullOfBooks;
}
