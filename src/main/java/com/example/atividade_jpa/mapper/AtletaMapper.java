package com.example.atividade_jpa.mapper;

import com.example.atividade_jpa.dto.atleta.AtletaRequisicaoDto;
import com.example.atividade_jpa.dto.atleta.AtletaRespostaDto;
import com.example.atividade_jpa.model.Atleta;
import org.springframework.stereotype.Component;

@Component
public class AtletaMapper {

public Atleta paraEntidade(AtletaRequisicaoDto atletaRequisicaoDto){
return new Atleta(
        atletaRequisicaoDto.nome(),
        atletaRequisicaoDto.posicao(),
        atletaRequisicaoDto.clube(),
        atletaRequisicaoDto.idade(),
        atletaRequisicaoDto.jogosCarreira(),
        atletaRequisicaoDto.aposentado()
);
}

public AtletaRespostaDto paraDto(Atleta atleta){
    return new AtletaRespostaDto(
            atleta.getId(),
            atleta.getNome(),
            atleta.getPosicao(),
            atleta.getClube(),
            atleta.getIdade(),
            atleta.getJogosCarreira(),
            atleta.isAposentado()
    );
}

}
