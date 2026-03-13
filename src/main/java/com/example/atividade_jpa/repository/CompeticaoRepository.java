package com.example.atividade_jpa.repository;

import com.example.atividade_jpa.model.Competicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompeticaoRepository extends JpaRepository<Competicao, Long> {
}
