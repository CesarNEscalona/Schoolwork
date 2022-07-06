package edu.greenriver.sdev.resttemplatejokes.service;

import edu.greenriver.sdev.resttemplatejokes.model.Joke;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppJokeService {

    public Joke[] getAllJokes() {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Joke[]> response = rest.getForEntity("http://localhost:8080/api/v1/jokes", Joke[].class);
        Joke[] jokes = response.getBody();
        return jokes;
    }
}
