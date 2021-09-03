package com.americanas.desafio_star_wars.model.api.star_wars;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PlanetaApiStarWars {

    @JsonProperty(value = "films")
    private String[] filmes;
}
