package com.example.atividade_jpa.controller;

import com.example.atividade_jpa.dto.competicao.CompeticaoRequisicaoDto;
import com.example.atividade_jpa.dto.competicao.CompeticaoRespostaDto;
import com.example.atividade_jpa.service.CompeticaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/competicao")
@RequiredArgsConstructor
public class CompeticaoController {

    private final CompeticaoService competicaoService;

    @PostMapping
    public CompeticaoRespostaDto criar(@RequestBody CompeticaoRequisicaoDto competicaoRequisicaoDto){
        try {
            return competicaoService.criarCompeticao(competicaoRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<CompeticaoRespostaDto> listar(){
        try {
            return competicaoService.listarTodas();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public CompeticaoRespostaDto atualizar(@RequestBody CompeticaoRequisicaoDto competicaoRequisicaoDto, @PathVariable Long id){
        try {
            return competicaoService.atualizar(competicaoRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        try {
            competicaoService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
