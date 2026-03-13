package com.example.atividade_jpa.service;

import com.example.atividade_jpa.dto.titulo.TituloRequisicaoDto;
import com.example.atividade_jpa.dto.titulo.TituloRespostaDto;
import com.example.atividade_jpa.mapper.TituloMapper;
import com.example.atividade_jpa.model.Titulo;
import com.example.atividade_jpa.repository.TituloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TituloService {

    private final TituloMapper mapper;
    private final TituloRepository repository;

    public TituloRespostaDto criarTitulo(TituloRequisicaoDto tituloRequisicaoDto)throws SQLException {
        Titulo socioTorcedor = mapper.paraEntidade(tituloRequisicaoDto);
        repository.save(socioTorcedor);
        return mapper.paraDto(socioTorcedor);
    }

    public List<TituloRespostaDto> listarTodas()throws SQLException{
        List<Titulo> competicoes = repository.findAll();
        return competicoes.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public TituloRespostaDto atualizar(TituloRequisicaoDto tituloRespostaDto, Long id)throws SQLException{
        Titulo titulo = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Titulo não encontrada"));

        titulo.setNome(tituloRespostaDto.nome());
        titulo.setAno(tituloRespostaDto.ano());

        Titulo novaTitulo = repository.save(titulo);
        return mapper.paraDto(novaTitulo);
    }

    public void deletar(Long id)throws SQLException{
        repository.deleteById(id);
    }
}
