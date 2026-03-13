package com.example.atividade_jpa.repository;

import com.example.atividade_jpa.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
}
