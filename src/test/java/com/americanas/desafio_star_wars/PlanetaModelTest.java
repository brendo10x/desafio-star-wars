package com.americanas.desafio_star_wars;

import com.americanas.desafio_star_wars.model.Planeta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlanetaModelTest {

    @Test
    public void criarPlaneta() {

        Planeta planeta = new Planeta();
        planeta.setId(20);
        planeta.setNome("Planeta x");
        planeta.setClima("Clima y");
        planeta.setTerreno("Terreno x");

        assertNotNull(planeta);
    }
}
