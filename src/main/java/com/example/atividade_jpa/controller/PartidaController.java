package com.example.atividade_jpa.controller;

import com.example.atividade_jpa.dto.partida.PartidaRequisicaoDto;
import com.example.atividade_jpa.dto.partida.PartidaRespostaDto;
import com.example.atividade_jpa.service.PartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/partida")
@RequiredArgsConstructor
public class PartidaController {

    private final PartidaService partidaService;

    @PostMapping
    public PartidaRespostaDto criar(@RequestBody PartidaRequisicaoDto partidaRequisicaoDto){
        try {
            return partidaService.criarPartida(partidaRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<PartidaRespostaDto> listar(){
        try {
            return partidaService.listarTodas();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public PartidaRespostaDto atualizar(@RequestBody PartidaRequisicaoDto partidaRequisicaoDto, @PathVariable Long id){
        try {
            return partidaService.atualizar(partidaRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        try {
            partidaService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
