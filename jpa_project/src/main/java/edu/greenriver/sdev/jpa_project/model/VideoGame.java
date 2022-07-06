package edu.greenriver.sdev.jpa_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Games")
public class VideoGame {
    @Id
    @Column(name="GameTitle")
    private String name;
    @Column(name="Genres")
    private String genre;
    private int hoursToBeat;
    private String developer;

    @Transient //doesn't add it to the database
    private int playersOnline;

    private boolean online;

}
