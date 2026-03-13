package com.example.atividade_jpa.service;

import com.example.atividade_jpa.dto.partida.PartidaRequisicaoDto;
import com.example.atividade_jpa.dto.partida.PartidaRespostaDto;
import com.example.atividade_jpa.mapper.PartidaMapper;
import com.example.atividade_jpa.model.Partida;
import com.example.atividade_jpa.repository.PartidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PartidaService {

    private final PartidaMapper mapper;
    private final PartidaRepository repository;

    public PartidaRespostaDto criarPartida(PartidaRequisicaoDto partidaRequisicaoDto)throws SQLException {
        Partida partida = mapper.paraEntidade(partidaRequisicaoDto);
        repository.save(partida);
        return mapper.paraDto(partida);
    }

    public List<PartidaRespostaDto> listarTodas()throws SQLException{
        List<Partida> competicoes = repository.findAll();
        return competicoes.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public PartidaRespostaDto atualizar(PartidaRequisicaoDto partidaRequisicaoDto, Long id)throws SQLException{
        Partida partida = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Partida não encontrada"));

        partida.setAdversario(partidaRequisicaoDto.adversario());
        partida.setEstadio(partidaRequisicaoDto.estadio());
        partida.setPlacar(partidaRequisicaoDto.placar());

        Partida novaPartida = repository.save(partida);
        return mapper.paraDto(novaPartida);
    }

    public void deletar(Long id)throws SQLException{
        repository.deleteById(id);
    }
}
