package edu.greenriver.sdev.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Joke
{
    private int jokeId;
    private String jokeText;

    public Joke(String jokeText)
    {
        this.jokeText = jokeText;
    }
}