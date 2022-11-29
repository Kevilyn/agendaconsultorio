package com.example.PIClinica.repository;

import com.example.PIClinica.model.Dentista;
import com.example.PIClinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DentistaRepository extends JpaRepository<Dentista, Integer> {

    @Query("Select dentista d from Dentista where d.nome = ?1")
    Optional<Dentista> findDentistaByNome(String nome);
}
