package com.example.atividade_jpa.dto.titulo;

public record TituloRequisicaoDto(
        String nome,
        int ano,
        String edicao,
        String cidadeSede,
        String adversarioFinal,
        int publicoPresente
) {
}
