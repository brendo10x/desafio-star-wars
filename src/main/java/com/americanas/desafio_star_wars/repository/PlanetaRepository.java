package com.americanas.desafio_star_wars.repository;

import com.americanas.desafio_star_wars.model.Planeta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PlanetaRepository extends MongoRepository<Planeta, String> {

    @Query("{ 'nome' : { '$regex' : ?0 , $options: 'i'}}")
    public List<Planeta> findByNome(String nome);

}

