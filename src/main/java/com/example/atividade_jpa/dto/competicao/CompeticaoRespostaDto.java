package com.example.atividade_jpa.dto.competicao;

public record CompeticaoRespostaDto(

        long id,
        String nome,
        int ano,
        String organizador,
         String tipoCompeticao,
        String tempoDuracao,
        double premiacao
) {
}
