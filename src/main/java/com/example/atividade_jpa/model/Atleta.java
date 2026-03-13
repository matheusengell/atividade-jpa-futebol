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

    @Column(nullable = false)
    private String clube;

    @Column(nullable = false)
    private int idade;

    @Column(nullable = false)
    private int jogosCarreira;

    @Column(nullable = false)
    private boolean aposentado;


    public Atleta(String nome, String posicao, String clube, int idade, int jogosCarreira, boolean aposentado) {
        this.nome = nome;
        this.posicao = posicao;
        this.clube = clube;
        this.idade = idade;
        this.jogosCarreira = jogosCarreira;
        this.aposentado = aposentado;
    }
}
