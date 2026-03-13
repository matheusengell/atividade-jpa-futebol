package com.example.atividade_jpa.mapper;

import com.example.atividade_jpa.dto.titulo.TituloRequisicaoDto;
import com.example.atividade_jpa.dto.titulo.TituloRespostaDto;
import com.example.atividade_jpa.model.Titulo;
import org.springframework.stereotype.Component;

@Component
public class TituloMapper {

    public Titulo paraEntidade(TituloRequisicaoDto dto) {
        Titulo titulo = new Titulo();
        titulo.setNome(dto.nome());
        titulo.setAno(dto.ano());
        return titulo;
    }

    public TituloRespostaDto paraDto(Titulo titulo) {
        return new TituloRespostaDto(
                titulo.getId(),
                titulo.getNome(),
                titulo.getAno()
        );
    }
}
