package com.example.atividade_jpa.mapper;

import com.example.atividade_jpa.dto.socioTorcedor.SocioTorcedorRespostaDto;
import com.example.atividade_jpa.model.SocioTorcedor;
import org.springframework.stereotype.Component;

@Component
public class SocioTorcedorMapper {
    public SocioTorcedor paraEntidade(SocioTorcedorRespostaDto dto) {
        SocioTorcedor socio = new SocioTorcedor();

        socio.setNome(dto.nome());
        socio.setCpf(dto.cpf());
        socio.setPlano(dto.plano());

        return socio;
    }

    public SocioTorcedorRespostaDto paraDto(SocioTorcedor socioTorcedor){
        return new SocioTorcedorRespostaDto(
               socioTorcedor.getId(),
                socioTorcedor.getNome(),
                socioTorcedor.getCpf(),
                socioTorcedor.getPlano()
        );
    }

}
