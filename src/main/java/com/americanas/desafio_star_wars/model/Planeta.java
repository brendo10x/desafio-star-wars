package com.americanas.desafio_star_wars.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Planeta {

    @Id
    private String id;
    private String nome;
    private String clima;
    private String terreno;
    @Transient
    private Long qtdAparicoesEmFilmes;

}
