package edu.greenriver.sdev.restapi.controllers;

import edu.greenriver.sdev.restapi.model.Joke;
import edu.greenriver.sdev.restapi.services.JokesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // runs the test on a random port
public class JokesApiTest {
    // access the random port
    @LocalServerPort
    private int port;

    // we need a class to help make the HTTP requests
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JokesService jokesService;

    @Test
    public void testGetAllJokes() {
        // put together our request
        HttpEntity request = new HttpEntity(new HttpHeaders());
        ResponseEntity<Joke[]> response = restTemplate.exchange("http://localhost:" + port + "/api/v1/jokes",
                HttpMethod.GET, request, Joke[].class);
        Joke[] jokes = response.getBody();

        // verify the status code and response body
        assertEquals(HttpStatus.OK, response.getStatusCode());
        //assertEquals(storedJokes.size(), jokes.length);
    }

    @Test
    public void testAddJoke() {
        // put together our request
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Joke newJoke = new Joke("Chuck Norris can't commit suicide");
        HttpEntity<Joke> request = new HttpEntity<>(newJoke, headers);


        ResponseEntity<Joke> response = restTemplate.exchange(
                "http://localhost:" + port + "/api/v1/jokes",
                HttpMethod.POST, request, Joke.class);


        //check whether POST gives back saved Joke
        Joke savedJoke = response.getBody();

        // verify the status code and response body
        assertNotEquals(0, savedJoke);
        assertEquals(savedJoke.getJokeText(), newJoke.getJokeText());
    }
}
