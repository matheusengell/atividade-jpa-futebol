package com.example.atividade_jpa.controller;

import com.example.atividade_jpa.dto.titulo.TituloRequisicaoDto;
import com.example.atividade_jpa.dto.titulo.TituloRespostaDto;
import com.example.atividade_jpa.service.TituloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.sql.SQLException;

@RestController
@RequestMapping("/titulos")
@RequiredArgsConstructor
public class TituloController {

    private final TituloService service;

    @PostMapping
    public TituloRespostaDto criar(@RequestBody TituloRequisicaoDto dto) {
        try {
            return service.criarTitulo(dto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<TituloRespostaDto> listar() {
       try {
           return service.listarTodas();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    @PutMapping("/{id}")
    public TituloRespostaDto atualizar(@RequestBody TituloRequisicaoDto tituloRequisicaoDto, @PathVariable Long id){
        try {
            return service.atualizar(tituloRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping ("/{id}")
    public void deletar(@PathVariable Long id){
        try {
            service.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
