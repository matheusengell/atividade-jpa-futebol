package com.example.atividade_jpa.dto.competicao;

import jakarta.validation.constraints.NotBlank;

public record CompeticaoRequisicaoDto(

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O ano é obrigatório")
        int ano,

        @NotBlank(message = "O organizador é obrigatório")
        String organizador,

        String tipoCompeticao,
        String tempoDuracao,
        double premiacao
) {
}
