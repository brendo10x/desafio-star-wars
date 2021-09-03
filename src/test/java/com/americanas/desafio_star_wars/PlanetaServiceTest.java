package com.americanas.desafio_star_wars;


import static org.hamcrest.Matchers.*;

import com.americanas.desafio_star_wars.model.Planeta;
import com.americanas.desafio_star_wars.service.PlanetaService;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class PlanetaServiceTest {

    @Autowired
    PlanetaService planetaService;

    @Ignore
    public void salvarPlanetaTest() {
        Planeta planeta = new Planeta();
        planeta.setId("10");
        planeta.setNome("Brendo");
        planeta.setClima("Tete");

        planetaService.savePlaneta(planeta);

    }

    @Test
    public void findAllTest() {

        List<Planeta> planetas = planetaService.findAll();

        assertThat(planetas, not(IsEmptyCollection.empty()));
        assertThat(planetas, hasSize(3));

    }

}
