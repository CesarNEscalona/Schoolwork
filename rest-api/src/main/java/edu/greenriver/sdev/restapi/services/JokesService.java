package edu.greenriver.sdev.restapi.services;

import edu.greenriver.sdev.restapi.model.Joke;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class JokesService {
    private int nextId = 0;
    private List<Joke> jokes = new ArrayList();

    private JokesService()
    {
        //add some test records
        List<Joke> startingRecords = List.of(
                new Joke("Chuck Norris doesn’t read books. He stares them down until he gets the information he wants."),
                new Joke("Time waits for no man. Unless that man is Chuck Norris."),
                new Joke("If you spell Chuck Norris in Scrabble, you win. Forever."),
                new Joke("Chuck Norris breathes air … five times a day."),
                new Joke("In the Beginning there was nothing … then Chuck Norris roundhouse kicked nothing and told it to " +
                        "get a job."),
                new Joke("When God said, “Let there be light!” Chuck said, “Say Please.”"),
                new Joke("Chuck Norris has a mug of nails instead of coffee in the morning."),
                new Joke("If Chuck Norris were to travel to an alternate dimension in which there was another Chuck " +
                        "Norris and they both fought, they would both win."),
                new Joke("The dinosaurs looked at Chuck Norris the wrong way once. You know what happened to them."),
                new Joke("Chuck Norris’ tears cure cancer. Too bad he has never cried."),
                new Joke("Chuck Norris once roundhouse kicked someone so hard that his foot broke the speed of light"),
                new Joke("If you ask Chuck Norris what time it is, he always says, ‘Two seconds till.’ After you ask, " +
                        "‘Two seconds to what?’ he roundhouse kicks you in the face.")
        );

        for (Joke record : startingRecords)
        {
            addJoke(record);
        }
    }

    public boolean idMatchesJoke(int id){
        return id >= 0 && id < nextId;
    }

    public List<Joke> getJokes()
    {
        return jokes;
    }

    public Joke getJokeById(int id)
    {
        return jokes.stream()
                .filter(joke -> joke.getJokeId() == id)
                .findFirst().orElse(null);
    }

    public Joke addJoke(Joke joke)
    {
        //save a new id to the joke object being saved
        joke.setJokeId(nextId++);
        jokes.add(joke);
        return joke;
    }

    public Joke editJoke(int jokeId, Joke editedJoke)
    {
        Joke savedJoke = getJokeById(jokeId);
        if (savedJoke != null)
        {
            savedJoke.setJokeText(editedJoke.getJokeText());
            return savedJoke;
        }
        //what should we do here?
        throw new IllegalArgumentException("Joke with id " + jokeId + " not found!");
    }

    public void deleteJoke(int jokeId)
    {
        Joke match = getJokeById(jokeId);
        if (match != null)
        {
            //we need to find this element in our list and remove it
            jokes.remove(match);
        }
    }
}
