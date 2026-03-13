package com.example.atividade_jpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "competicao")

public class Competicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false)
    private String nome;

    @Column (nullable = false)
    private int ano;

    @Column (nullable = false)
    private String organizador;


    public Competicao(String nome, int ano, String organizador) {
        this.nome = nome;
        this.ano = ano;
        this.organizador = organizador;
    }
}
