package com.example.atividade_jpa.controller;

import com.example.atividade_jpa.dto.atleta.AtletaRequisicaoDto;
import com.example.atividade_jpa.dto.atleta.AtletaRespostaDto;
import com.example.atividade_jpa.model.Atleta;
import com.example.atividade_jpa.service.AtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/atleta")
@RequiredArgsConstructor
public class AtletaController {

    private final AtletaService atletaService;



    @PostMapping
    public AtletaRespostaDto criar(@RequestBody AtletaRequisicaoDto atletaRequisicaoDto){
        try {
            return atletaService.criarAtleta(atletaRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<AtletaRespostaDto> listar(){
        try {
            return atletaService.listarAtletas();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public AtletaRespostaDto listarPorId(@PathVariable long id){
        try {
            return atletaService.listarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public AtletaRespostaDto atualizar(@RequestBody AtletaRequisicaoDto atletaRequisicaoDto, @PathVariable long id){
        try {
            return atletaService.atualizar(atletaRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        try {
            atletaService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
