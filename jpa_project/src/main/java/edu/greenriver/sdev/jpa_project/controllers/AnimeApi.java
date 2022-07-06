package edu.greenriver.sdev.jpa_project.controllers;

import edu.greenriver.sdev.jpa_project.model.Anime;
import edu.greenriver.sdev.jpa_project.service.AnimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/anime")
public class AnimeApi {

    private AnimeService service;

    public AnimeApi(AnimeService service) {
        this.service = service;
    }

    public ResponseEntity<List<Anime>> getAllAnimes(){
        List<Anime> animes = service.getAnimes();

        return ResponseEntity.ok(animes);
    }
}
