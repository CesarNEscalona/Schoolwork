package edu.greenriver.sdev.restapi.controllers;

import edu.greenriver.sdev.restapi.model.Joke;
import edu.greenriver.sdev.restapi.services.JokesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/jokes") // start all routes with /jokes
@CrossOrigin(origins="*")
public class JokesApi
{
    private JokesService service;

    public JokesApi(JokesService service)
    {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Joke>> getAllJokes()
    {
        return new ResponseEntity<>(service.getJokes(), HttpStatus.OK);
    }

    @GetMapping("{jokeId}")
    public ResponseEntity<Joke> getSingleJoke(@PathVariable int jokeId)
    {
        // preconditions - negative ids, or ids not in use
        if(jokeId < 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else if (!service.idMatchesJoke(jokeId)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(service.getJokeById(jokeId), HttpStatus.OK);
    }

    @PostMapping("")
    public Joke addJoke(@RequestBody Joke joke)
    {
        return service.addJoke(joke);
    }

    @PutMapping("{jokeId}")
    public Joke updateJoke(@PathVariable int jokeId, @RequestBody Joke joke)
    {
        return service.editJoke(jokeId, joke);
    }

    @DeleteMapping("{jokeId}")
    public void deleteJoke(@PathVariable int jokeId)
    {
        service.deleteJoke(jokeId);
    }
}