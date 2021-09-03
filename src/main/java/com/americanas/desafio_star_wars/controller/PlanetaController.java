package com.americanas.desafio_star_wars.controller;

import com.americanas.desafio_star_wars.model.Planeta;
import com.americanas.desafio_star_wars.service.PlanetaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/planetas/")
@AllArgsConstructor
public class PlanetaController {

    private PlanetaService planetaService;

    @RequestMapping()
    public List<Planeta> getAllPlanetas() {
        return planetaService.findAll();
    }

    @GetMapping(value = "/buscar-por-nome/{nome}")
    public List<Planeta> getPlanetasByNome(@PathVariable("nome") String nome) {
        return planetaService.findByNome(nome);
    }

    @GetMapping(value = "/{id}")
    public Planeta getPlanetaById(@PathVariable("id") Integer id) {
        return planetaService.findById(id);
    }

    @GetMapping(value = "/remover/{id}")
    public List<Planeta> removePlanetaById(@PathVariable("id") Integer id) {
        planetaService.removePlaneta(id);
        return planetaService.findAll();
    }

    @PostMapping
    public List<Planeta> savePlaneta(@RequestBody Planeta planeta) {
        planetaService.savePlaneta(planeta);
        return planetaService.findAll();
    }
}
