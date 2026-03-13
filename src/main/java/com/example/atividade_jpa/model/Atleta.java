package com.example.atividade_jpa.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "atleta")
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String posicao;

    @Column
    private String clube;

    public Atleta(String nome, String posicao, String clube) {
        this.nome = nome;
        this.posicao = posicao;
        this.clube = clube;
    }
}
