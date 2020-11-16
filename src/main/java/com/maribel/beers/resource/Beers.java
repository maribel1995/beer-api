package com.maribel.beers.resource;

import com.maribel.beers.entity.Beer;
import com.maribel.beers.repository.BeerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/beers")
public class Beers {

    private BeerRepository beerRepository;

    public Beers(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @GetMapping
    public ResponseEntity<List<Beer>> getBeers() {
        List<Beer> beers = new ArrayList<>();
        beers.add(new Beer("Madalena Weiss", "Weiss"));
        beers.add(new Beer("Madalena Session Ipa", "Session Ipa"));
        beers.add(new Beer("Colorado Ribeirão", "Larger"));
        return ResponseEntity.ok(beers);
    }

    @PostMapping
    public ResponseEntity<Beer> addBeer(@RequestBody Beer beer) {
        beerRepository.save(beer);
        return ResponseEntity.status(HttpStatus.CREATED).body(beer);
    }
}
