package com.example.atividade_jpa.dto.partida;

public record PartidaRespostaDto(

        long id,
        String adversario,
        String estadio,
        String placar,
         String competicao,
        String tipo,
        String totalIngressoDisponivel
) {
}
