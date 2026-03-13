package com.example.atividade_jpa.service;

import com.example.atividade_jpa.dto.atleta.AtletaRequisicaoDto;
import com.example.atividade_jpa.dto.atleta.AtletaRespostaDto;
import com.example.atividade_jpa.mapper.AtletaMapper;
import com.example.atividade_jpa.model.Atleta;
import com.example.atividade_jpa.repository.AtletaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AtletaService {

    private final AtletaMapper atletaMapper;
    private final AtletaRepository atletaRepository;


    public AtletaRespostaDto criarAtleta(AtletaRequisicaoDto atletaRequisicaoDto)throws SQLException{
        Atleta atleta = atletaMapper.paraEntidade(atletaRequisicaoDto);
        atletaRepository.save(atleta);
        return atletaMapper.paraDto(atleta);
    }

    public List<AtletaRespostaDto> listarAtletas(){
        List<Atleta> atletas = atletaRepository.findAll();
        return atletas.stream()//atletas passam um por um para ser processados(esteira)
                .map(atletaMapper::paraDto)//Para cada atleta que passar na esteira, ele chama o método paraDto do seu atletaMapper.
                .toList(); //Ele "fecha a porteira". Depois que todos os atletas foram convertidos em DTOs
    }

    public AtletaRespostaDto listarPorId(long id)throws SQLException{
        Atleta atleta = atletaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atleta não encontrado"));
        return atletaMapper.paraDto(atleta);
    }

    public AtletaRespostaDto atualizar(AtletaRequisicaoDto atletaRequisicaoDto, Long id)throws SQLException{
        Atleta atleta = atletaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Atleta não encontrado"));

        atleta.setNome(atletaRequisicaoDto.nome());
        atleta.setPosicao(atletaRequisicaoDto.posicao());
        atleta.setClube(atletaRequisicaoDto.clube());

        Atleta atletaAtualizado = atletaRepository.save(atleta);
        return atletaMapper.paraDto(atletaAtualizado);
    }

    public void deletar(long id)throws SQLException{
        atletaRepository.deleteById(id);
    }

}
