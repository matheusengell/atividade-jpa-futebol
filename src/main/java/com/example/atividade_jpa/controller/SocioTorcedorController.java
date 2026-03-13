package com.example.atividade_jpa.controller;

import com.example.atividade_jpa.dto.socioTorcedor.SocioTorcedorRespostaDto;
import com.example.atividade_jpa.service.SocioTorcedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/socio")
@RequiredArgsConstructor
public class SocioTorcedorController {

    private final SocioTorcedorService socioTorcedorService;

    @PostMapping
    public SocioTorcedorRespostaDto criar(@RequestBody SocioTorcedorRespostaDto socioTorcedorRequisicaoDto){
        try {
            return socioTorcedorService.criarPartida(socioTorcedorRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<SocioTorcedorRespostaDto> listar(){
        try {
            return socioTorcedorService.listarTodas();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public SocioTorcedorRespostaDto atualizar(@RequestBody SocioTorcedorRespostaDto socioTorcedorRequisicaoDto, @PathVariable Long id){
        try {
            return socioTorcedorService.atualizar(socioTorcedorRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        try {
            socioTorcedorService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
