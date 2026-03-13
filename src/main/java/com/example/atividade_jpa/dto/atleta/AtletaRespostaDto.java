package com.example.atividade_jpa.dto.atleta;

public record AtletaRespostaDto(
        long id,
        String nome,
        String posicao,
        String clube,
        int idade,
        int jogosCarreira,
        boolean aposentado
) {
}
