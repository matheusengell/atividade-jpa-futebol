package com.example.atividade_jpa.service;

import com.example.atividade_jpa.dto.socioTorcedor.SocioTorcedorRespostaDto;
import com.example.atividade_jpa.mapper.SocioTorcedorMapper;
import com.example.atividade_jpa.model.SocioTorcedor;
import com.example.atividade_jpa.repository.SocioTorcedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SocioTorcedorService {


    private final SocioTorcedorMapper mapper;
    private final SocioTorcedorRepository repository;

    public SocioTorcedorRespostaDto criarPartida(SocioTorcedorRespostaDto socioTorcedorRequisicaoDto)throws SQLException {
        SocioTorcedor socioTorcedor = mapper.paraEntidade(socioTorcedorRequisicaoDto);
        repository.save(socioTorcedor);
        return mapper.paraDto(socioTorcedor);
    }

    public List<SocioTorcedorRespostaDto> listarTodas()throws SQLException{
        List<SocioTorcedor> competicoes = repository.findAll();
        return competicoes.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public SocioTorcedorRespostaDto atualizar(SocioTorcedorRespostaDto socioTorcedorRequisicaoDto, Long id)throws SQLException{
        SocioTorcedor socioTorcedor = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("SocioTorcedor não encontrada"));

        socioTorcedor.setNome(socioTorcedorRequisicaoDto.nome());
        socioTorcedor.setCpf(socioTorcedorRequisicaoDto.cpf());
        socioTorcedor.setPlano(socioTorcedorRequisicaoDto.plano());

        SocioTorcedor novaSocioTorcedor = repository.save(socioTorcedor);
        return mapper.paraDto(novaSocioTorcedor);
    }

    public void deletar(Long id)throws SQLException{
        repository.deleteById(id);
    }
}
