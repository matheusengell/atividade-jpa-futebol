package com.example.atividade_jpa.service;

import com.example.atividade_jpa.dto.atleta.AtletaRespostaDto;
import com.example.atividade_jpa.dto.competicao.CompeticaoRequisicaoDto;
import com.example.atividade_jpa.dto.competicao.CompeticaoRespostaDto;
import com.example.atividade_jpa.mapper.CompeticaoMapper;
import com.example.atividade_jpa.model.Competicao;
import com.example.atividade_jpa.repository.CompeticaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompeticaoService {

    private final CompeticaoMapper competicaoMapper;
    private final CompeticaoRepository competicaoRepository;

    public CompeticaoRespostaDto criarCompeticao(CompeticaoRequisicaoDto competicaoRequisicaoDto)throws SQLException{
        Competicao competicao = competicaoMapper.paraEntidade(competicaoRequisicaoDto);
        competicaoRepository.save(competicao);
        return competicaoMapper.paraDto(competicao);
    }

    public List<CompeticaoRespostaDto> listarTodas()throws SQLException{
        List<Competicao> competicoes = competicaoRepository.findAll();
        return competicoes.stream()
                .map(competicaoMapper::paraDto)
                .toList();
    }

    public CompeticaoRespostaDto atualizar(CompeticaoRequisicaoDto competicaoRequisicaoDto, Long id)throws SQLException{
        Competicao competicao = competicaoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Competição não encontrada"));

        competicao.setNome(competicaoRequisicaoDto.nome());
        competicao.setAno(competicaoRequisicaoDto.ano());
        competicao.setOrganizador(competicaoRequisicaoDto.organizador());

        Competicao novaCompeticao = competicaoRepository.save(competicao);
        return competicaoMapper.paraDto(competicao);
    }

    public void deletar(Long id)throws SQLException{
        competicaoRepository.deleteById(id);
    }
}
