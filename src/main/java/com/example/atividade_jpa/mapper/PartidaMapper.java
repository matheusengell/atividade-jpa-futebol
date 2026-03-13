package com.example.atividade_jpa.mapper;

import com.example.atividade_jpa.dto.partida.PartidaRequisicaoDto;
import com.example.atividade_jpa.dto.partida.PartidaRespostaDto;
import com.example.atividade_jpa.model.Partida;
import org.springframework.stereotype.Component;

@Component
public class PartidaMapper {

    public Partida paraEntidade(PartidaRequisicaoDto partidaRequisicaoDto){
        return new Partida(
                partidaRequisicaoDto.adversario(),
                partidaRequisicaoDto.estadio(),
                partidaRequisicaoDto.placar()
        );
    }

    public PartidaRespostaDto paraDto(Partida partida){
        return new PartidaRespostaDto(
                partida.getId(),
                partida.getAdversario(),
                partida.getEstadio(),
                partida.getPlacar()
        );
    }
}
