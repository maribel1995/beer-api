package com.maribel.beers.repository;

import com.maribel.beers.entity.Beer;
import org.springframework.data.repository.CrudRepository;

public interface BeerRepository extends CrudRepository<Beer, Integer> {
}
