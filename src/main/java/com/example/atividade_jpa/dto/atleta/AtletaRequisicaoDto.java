package com.example.atividade_jpa.dto.atleta;

import jakarta.validation.constraints.NotBlank;

public record AtletaRequisicaoDto(
        @NotBlank(message = "O nome é obrigatório")
        String nome,
        @NotBlank(message = "O nome é obrigatório")
        String posicao,
        String clube,
        int idade,
        int jogosCarreira,
        boolean aposentado

) {
}
