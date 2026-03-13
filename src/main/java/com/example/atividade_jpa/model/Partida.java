package com.example.atividade_jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "partida")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String adversario;

    @Column(nullable = false)
    private String estadio;

    @Column(nullable = false)
    private String placar;

    private String competicao;

    private String tipo;

    private String totalIngressoDisponivel;

    public Partida(String adversario, String estadio, String placar, String competicao, String tipo, String totalIngressoDisponivel) {
        this.adversario = adversario;
        this.estadio = estadio;
        this.placar = placar;
        this.competicao = competicao;
        this.tipo = tipo;
        this.totalIngressoDisponivel = totalIngressoDisponivel;
    }
}
