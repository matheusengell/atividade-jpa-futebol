package com.example.atividade_jpa.repository;


import com.example.atividade_jpa.model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AtletaRepository extends JpaRepository<Atleta, Long> {

}
