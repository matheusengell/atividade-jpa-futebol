package com.example.atividade_jpa.repository;

import com.example.atividade_jpa.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TituloRepository extends JpaRepository<Titulo, Long> {
}
