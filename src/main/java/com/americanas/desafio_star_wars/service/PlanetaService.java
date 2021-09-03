package com.americanas.desafio_star_wars.service;

import com.americanas.desafio_star_wars.model.Planeta;
import com.americanas.desafio_star_wars.model.api.star_wars.PlanetaApiStarWars;
import com.americanas.desafio_star_wars.repository.PlanetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PlanetaService {

    private final PlanetaRepository planetaRepository;

    public List<Planeta> findAll() {
        return planetaRepository
                .findAll()
                .stream()
                .map(planeta -> {
                    planeta.setQtdAparicoesEmFilmes(atualizaQdtAparicoesEmFilmes(planeta));
                    return planeta;
                }).collect(Collectors.toList());
    }

    public List<Planeta> findByNome(String nome) {
        return planetaRepository
                .findByNome(nome)
                .stream()
                .map(planeta -> {
                    planeta.setQtdAparicoesEmFilmes(atualizaQdtAparicoesEmFilmes(planeta));
                    return planeta;
                }).collect(Collectors.toList());
    }

    public Planeta findById(Integer id) {
        return planetaRepository.findById(id).map(planeta -> {
            planeta.setQtdAparicoesEmFilmes(atualizaQdtAparicoesEmFilmes(planeta));
            return planeta;
        }).orElse(new Planeta());
    }

    public void removePlaneta(Integer id) {
        planetaRepository.deleteById(id);
    }

    public void savePlaneta(Planeta planeta) {
        planetaRepository.save(planeta);
    }

    @Autowired
    private WebClient webClient;

    public Long atualizaQdtAparicoesEmFilmes(Planeta planeta) {

        Mono<PlanetaApiStarWars> monoPlanetaApiStarWars = webClient
                .method(HttpMethod.GET)
                .uri("planets/{id}", planeta.getId())
                .retrieve().
                bodyToMono(PlanetaApiStarWars.class);

        PlanetaApiStarWars p = monoPlanetaApiStarWars.block();

        return Arrays.stream(p.getFilmes()).count();
    }

}
