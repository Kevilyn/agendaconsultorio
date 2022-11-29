package com.example.PIClinica.repository;

import com.example.PIClinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    @Query("Select paciente p from Paciente where p.nome = ?1")
    Optional<Paciente> findPacienteByNome(String nome);

}
