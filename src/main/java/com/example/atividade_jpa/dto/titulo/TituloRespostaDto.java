package com.example.atividade_jpa.dto.titulo;

public record TituloRespostaDto(
        Long id,
        String nome,
        int ano,
        String edicao,
        String cidadeSede,
        String adversarioFinal,
        int publicoPresente
) {
}
