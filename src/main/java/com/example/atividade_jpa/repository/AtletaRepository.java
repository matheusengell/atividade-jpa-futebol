package com.example.atividade_jpa.repository;


import com.example.atividade_jpa.model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AtletaRepository extends JpaRepository<Atleta, Long> {

    List<Atleta> findByNomeAndClubeInAndPosicaoIn(String nome,List<String> clubes, List<String> posicoes);
}
