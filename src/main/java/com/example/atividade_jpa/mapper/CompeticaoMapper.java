package com.example.atividade_jpa.mapper;

import com.example.atividade_jpa.dto.competicao.CompeticaoRequisicaoDto;
import com.example.atividade_jpa.dto.competicao.CompeticaoRespostaDto;
import com.example.atividade_jpa.model.Atleta;
import com.example.atividade_jpa.model.Competicao;
import org.springframework.stereotype.Component;

@Component
public class CompeticaoMapper {

    public Competicao paraEntidade(CompeticaoRequisicaoDto competicaoRequisicaoDto){
        return new Competicao(
                competicaoRequisicaoDto.nome(),
                competicaoRequisicaoDto.ano(),
                competicaoRequisicaoDto.organizador()
        );
    }

    public CompeticaoRespostaDto paraDto(Competicao competicao){
        return new CompeticaoRespostaDto(
                competicao.getId(),
                competicao.getNome(),
                competicao.getAno(),
                competicao.getOrganizador()
        );
    }

}
